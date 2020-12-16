package com.jwebmp.core.base.angular.directives.events.submit;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.submit.IOnSubmitService;
import com.guicedee.guicedinjection.json.StaticStrings;

public class OnSubmit
		implements IOnSubmitService<OnSubmit>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngSubmit),
			                                                "jwCntrl.jw.isLoading || " + com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
