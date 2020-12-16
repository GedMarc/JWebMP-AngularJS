package com.jwebmp.core.base.angular.directives.events.mouseup;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.events.mouseup.IOnMouseUpService;
import com.guicedee.guicedinjection.json.StaticStrings;

public class OnMouseUp
		implements IOnMouseUpService<OnMouseUp>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			AngularPageConfigurator.setRequired(true);
			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngMouseup), com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
