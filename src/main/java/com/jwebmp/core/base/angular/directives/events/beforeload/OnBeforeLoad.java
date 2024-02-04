package com.jwebmp.core.base.angular.directives.events.beforeload;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.beforeload.IOnBeforeLoadService;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

public class OnBeforeLoad
		implements IOnBeforeLoadService<OnBeforeLoad>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngBeforeLoad),
			                                                com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
