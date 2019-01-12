package com.jwebmp.core.base.angular.directives.events.keypressed;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.events.keypressed.IOnKeyPressedService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnKeyPressed
		implements IOnKeyPressedService<OnKeyPressed>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			AngularPageConfigurator.setRequired(true);
			e.getComponent()
			 .addAttribute(AngularAttributes.ngKeypress,
			               StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
