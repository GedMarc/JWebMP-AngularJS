package com.jwebmp.core.base.angular.directives.events.focus;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.focus.IOnFocusService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnFocus
		implements IOnFocusService<OnFocus>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			e.getComponent()
			 .addAttribute(AngularAttributes.ngFocus, StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
