package com.jwebmp.core.base.angular.directives.events.cancel;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.cancel.IOnCancelService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnCancel
		implements IOnCancelService<OnCancel>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent()
			 .addAttribute(AngularAttributes.ngCancel, StaticStrings.STRING_ANGULAR_EVENT_START +
			                                           e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
