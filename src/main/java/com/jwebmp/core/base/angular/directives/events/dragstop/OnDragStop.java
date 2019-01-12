package com.jwebmp.core.base.angular.directives.events.dragstop;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.dragstop.IOnDragStopService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnDragStop
		implements IOnDragStopService<OnDragStop>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			e.getComponent()
			 .addAttribute(AngularAttributes.ngDragStop,
			               StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
