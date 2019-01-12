package com.jwebmp.core.base.angular.directives.events.complete;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.complete.IOnCompleteService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnComplete
		implements IOnCompleteService<OnComplete>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent()
			 .addAttribute(AngularAttributes.ngComplete,
			               StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
