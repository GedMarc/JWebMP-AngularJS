package com.jwebmp.core.base.angular.directives.events.beforeactivate;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.beforeactivate.IOnBeforeActivateService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnBeforeActivate
		implements IOnBeforeActivateService<OnBeforeActivate>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent()
			 .addAttribute(AngularAttributes.ngBeforeActivate,
			               StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
