package com.jwebmp.core.base.angular.directives.events.mouseenter;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.events.mouseenter.IOnMouseEnterService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnMouseEnter
		implements IOnMouseEnterService<OnMouseEnter>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			AngularPageConfigurator.setRequired(true);
			e.getComponent()
			 .addAttribute(AngularAttributes.ngMouseenter,
			               StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
