package com.jwebmp.core.base.angular.directives.events.submit;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.submit.IOnSubmitService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnSubmit
		implements IOnSubmitService<OnSubmit>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent()
			 .addAttribute(AngularAttributes.ngSubmit,
			               "jwCntrl.jw.isLoading || " + StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
