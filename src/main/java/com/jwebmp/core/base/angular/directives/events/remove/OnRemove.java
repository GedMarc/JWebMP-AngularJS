package com.jwebmp.core.base.angular.directives.events.remove;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.remove.IOnRemoveService;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

public class OnRemove
		implements IOnRemoveService<OnRemove>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{

			e.getComponent().asAttributeBase().addAttribute(String.valueOf(AngularAttributes.ngRemove), com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
