package com.jwebmp.core.base.angular.directives.events.cancel;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.cancel.IOnCancelService;
import com.guicedee.guicedinjection.json.StaticStrings;

public class OnCancel
		implements IOnCancelService<OnCancel>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngCancel), com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  +
			                                           e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
