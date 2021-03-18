package com.jwebmp.core.base.angular.servlets;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.services.scopes.CallScoper;
import com.guicedee.guicedservlets.websockets.GuicedWebSocket;
import com.guicedee.guicedservlets.websockets.options.WebSocketMessageReceiver;
import com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver;
import com.guicedee.logger.LogFactory;
import com.jwebmp.core.Event;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ajax.*;
import com.jwebmp.core.base.servlets.AjaxReceiverServlet;
import com.jwebmp.core.exceptions.InvalidRequestException;
import com.jwebmp.core.exceptions.MissingComponentException;
import com.jwebmp.core.utilities.TextUtilities;
import com.jwebmp.interception.services.AjaxCallIntercepter;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.guicedee.guicedinjection.GuiceContext.get;
import static com.guicedee.guicedinjection.json.StaticStrings.CHAR_DOT;
import static com.guicedee.guicedinjection.json.StaticStrings.CHAR_UNDERSCORE;
import static com.jwebmp.interception.JWebMPInterceptionBinder.AjaxCallInterceptorKey;

public class WebSocketAjaxCallReceiver
		implements IWebSocketMessageReceiver
{
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("AJAXWebSocket");

	@Inject
	@Named("callScope")
	CallScoper scope;

	@Override
	public Set<String> messageNames()
	{
		Set<String> messageNames = new HashSet<>();
		messageNames.add("ajax");
		return messageNames;
	}
	
	@Override
	public void receiveMessage(WebSocketMessageReceiver message) throws SecurityException
	{
		String output;
		scope.enter();
		AjaxResponse<?> ajaxResponse = GuiceContext.get(AjaxResponse.class);
		try
		{
			AjaxCall<?> ajaxCall = GuiceContext.get(AjaxCall.class);
			AjaxCall<?> call = new AjaxCall<>().From(message.getData()
			                                                    .get("article")
			                                                    .toString(), AjaxCall.class);
			ajaxCall.fromCall(call);

			ajaxCall.setWebSocketCall(true);
			ajaxCall.setWebsocketSession(message.getSession());
			Event<?, ?> triggerEvent = processEvent(ajaxCall);
			for (AjaxCallIntercepter<?> ajaxCallIntercepter : get(AjaxCallInterceptorKey))
			{
				ajaxCallIntercepter.intercept(ajaxCall, ajaxResponse);
			}
			triggerEvent.fireEvent(ajaxCall, ajaxResponse);

			output = ajaxResponse.toString();

			GuicedWebSocket.broadcastMessage(message.getBroadcastGroup(), "Ok");
		}
		catch (InvalidRequestException ie)
		{
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction<?> arr = new AjaxResponseReaction<>("Invalid Request Value", "A value in the request was found to be incorrect.<br>" + ie.getMessage(),
					ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = ajaxResponse.toString();
			WebSocketAjaxCallReceiver.log.log(Level.SEVERE, "[SessionID]-[" + message.getData()
			                                                                         .get("sessionid")
					+ "];" + "[Exception]-[Invalid Request]", ie);
		}
		catch (Exception T)
		{
			ajaxResponse.setSuccess(false);
			AjaxResponseReaction<?> arr = new AjaxResponseReaction<>("Unknown Error",
					"An AJAX call resulted in an unknown server error<br>" + T.getMessage() + "<br>" + TextUtilities.stackTraceToString(
							T), ReactionType.DialogDisplay);
			arr.setResponseType(AjaxResponseType.Danger);
			ajaxResponse.addReaction(arr);
			output = ajaxResponse.toString();
			WebSocketAjaxCallReceiver.log.log(Level.SEVERE, "Unknown in ajax reply\n", T);
		}
		finally {
			scope.exit();
		}
		GuicedWebSocket.broadcastMessage(message.getBroadcastGroup(), output);
	}
	
	protected Event<?, ?> processEvent(AjaxCall<?> call) throws InvalidRequestException
	{
		Event<?, ?> triggerEvent = null;
		try
		{
			Class<?> eventClass = Class.forName(call.getClassName()
			                                        .replace(CHAR_UNDERSCORE, CHAR_DOT));
			triggerEvent = (Event<?, ?>) get(eventClass);
			triggerEvent.setID(call.getEventId());
		}
		catch (ClassNotFoundException cnfe)
		{
			@SuppressWarnings({"rawtypes", "unchecked"})
			Set<Class<? extends Event<?, ?>>> events = new HashSet(GuiceContext.instance()
			                                                                   .getScanResult()
			                                                                   .getSubclasses(Event.class.getCanonicalName())
			                                                                   .loadClasses());
			events.removeIf(event -> Modifier.isAbstract(event.getModifiers()));
			for (Class<? extends Event<?, ?>> event : events)
			{
				Event<?, ?> instance = get(event);
				if (instance.getID()
				            .equals(get(AjaxCall.class)
						            .getEventId()))
				{
					triggerEvent = instance;
					break;
				}
			}
			if (triggerEvent == null)
			{
				WebSocketAjaxCallReceiver.log.log(Level.FINEST, "Unable to find the event class specified", cnfe);
				throw new InvalidRequestException("The Event To Be Triggered Could Not Be Found");
			}
		}
		return triggerEvent;
	}
}
