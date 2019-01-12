package com.jwebmp.core.base.angular.directives.events.mouseover;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.mouseover.IOnMouseOverService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnMouseOver
		implements IOnMouseOverService<OnMouseOver>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			e.getComponent()
			 .addAttribute(AngularAttributes.ngMouseover,
			               StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}