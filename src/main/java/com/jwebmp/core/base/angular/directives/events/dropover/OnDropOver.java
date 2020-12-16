package com.jwebmp.core.base.angular.directives.events.dropover;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.dropover.IOnDropOverService;
import com.guicedee.guicedinjection.json.StaticStrings;

public class OnDropOver
		implements IOnDropOverService<OnDropOver>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngDropOver),
			                                                com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
