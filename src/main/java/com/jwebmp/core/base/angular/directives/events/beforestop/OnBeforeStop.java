package com.jwebmp.core.base.angular.directives.events.beforestop;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.beforestop.IOnBeforeStopService;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

public class OnBeforeStop
		implements IOnBeforeStopService<OnBeforeStop>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngBeforeStop),
			                                                com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}

	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
