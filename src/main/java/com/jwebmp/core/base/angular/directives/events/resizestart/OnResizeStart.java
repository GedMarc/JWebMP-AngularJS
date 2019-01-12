package com.jwebmp.core.base.angular.directives.events.resizestart;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.resizestart.IOnResizeStartService;
import com.jwebmp.core.utilities.StaticStrings;

public class OnResizeStart
		implements IOnResizeStartService<OnResizeStart>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			e.getComponent()
			 .addAttribute(AngularAttributes.ngResizeStart,
			               StaticStrings.STRING_ANGULAR_EVENT_START + e.renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
