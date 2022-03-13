package com.jwebmp.core.base.angular.directives.events.mousedown;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.events.mousedown.IOnMouseDownService;
import com.guicedee.guicedinjection.json.StaticStrings;

public class OnMouseDown
		implements IOnMouseDownService<OnMouseDown>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			
			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngMousedown),
			                                                com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
