package com.jwebmp.core.base.angular.directives.events.keyup;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.events.keyup.IOnKeyUpService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnKeyUp
		implements IOnKeyUpService<OnKeyUp>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			AngularPageConfigurator.setRequired(true);
			e.getComponent()
			 .addAttribute(AngularAttributes.ngKeyup, StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
