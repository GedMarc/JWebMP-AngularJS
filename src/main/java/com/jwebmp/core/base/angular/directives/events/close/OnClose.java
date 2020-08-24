package com.jwebmp.core.base.angular.directives.events.close;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.close.IOnCloseService;
import com.guicedee.guicedinjection.json.StaticStrings;

public class OnClose
		implements IOnCloseService<OnClose>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent()
			 .addAttribute(AngularAttributes.ngClose, com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START
			                                          + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
