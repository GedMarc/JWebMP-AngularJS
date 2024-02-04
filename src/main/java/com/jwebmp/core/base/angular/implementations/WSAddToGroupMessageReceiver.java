package com.jwebmp.core.base.angular.implementations;

import com.guicedee.guicedservlets.websockets.*;
import com.guicedee.guicedservlets.websockets.options.*;
import com.guicedee.guicedservlets.websockets.services.*;


import java.util.*;
import java.util.logging.*;

public class WSAddToGroupMessageReceiver
		implements IWebSocketMessageReceiver
{
	private static final Logger log = LogFactory.getLog("WSAddToGroupMessageReceiver");
	
	@Override
	public void receiveMessage(WebSocketMessageReceiver<?> message) throws SecurityException
	{
		try
		{
			String group = message.getData()
			                      .get("websocketGroup");
			GuicedWebSocket.addToGroup(group, message.getSession());
		}
		catch (Exception e)
		{
			WSAddToGroupMessageReceiver.log.log(Level.WARNING, "Unable to check for local storage key", e);
		}
	}
	
	@Override
	public Set<String> messageNames()
	{
		Set<String> messageNames = new HashSet<>();
		messageNames.add("AddToWebSocketGroup");
		return messageNames;
	}
	
}
