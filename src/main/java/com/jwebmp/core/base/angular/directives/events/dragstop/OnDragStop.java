package com.jwebmp.core.base.angular.directives.events.dragstop;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.dragstop.IOnDragStopService;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

public class OnDragStop
		implements IOnDragStopService<OnDragStop>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngDragStop),
			                                                com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
