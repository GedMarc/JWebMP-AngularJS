package com.jwebmp.core.base.angular.directives.events.click;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.click.IOnClickService;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

public class OnClicked
		implements IOnClickService<OnClicked>
{
	@Override
	public void onCreate(Event<?, ?> e)
	{
		if (e.getComponent() != null)
		{
			String command = //"jwCntrl.jw.isLoading || " +
					com.jwebmp.core.utilities.StaticStrings.STRING_ANGULAR_EVENT_START  +
					e.renderVariables() +
					StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON;

			if (e.getComponent().asAttributeBase()
			     .getAttribute(String.valueOf(AngularAttributes.ngClick)) == null)
			{
				e.getComponent().asAttributeBase()
				 .addAttribute(String.valueOf(AngularAttributes.ngClick), command);
			}
			else
			{
				e.getComponent().asAttributeBase()
				 .addAttribute(String.valueOf(AngularAttributes.ngClick), e.getComponent().asAttributeBase()
				                                                           .getAttribute(String.valueOf(AngularAttributes.ngClick)) + command);
			}

			if (e.getComponent().asAttributeBase()
			     .getAttribute(String.valueOf(AngularAttributes.ngDisabled)) == null)
			{
				e.getComponent().asAttributeBase()
				 .addAttribute(String.valueOf(AngularAttributes.ngDisabled), "jwCntrl.jw.isLoading");
			}
			else if (!"jwCntrl.jw.isLoading".equals(e.getComponent().asAttributeBase()
			                                         .getAttribute(String.valueOf(AngularAttributes.ngDisabled))))
			{
				String disabledOn = "jwCntrl.jw.isLoading ";
				if (!"".equals(e.getComponent().asAttributeBase()
				                .getAttribute(String.valueOf(AngularAttributes.ngDisabled))) && e.getComponent().asAttributeBase()
				                                                                                 .getAttribute(String.valueOf(AngularAttributes.ngDisabled)) != null)
				{
					disabledOn += " || " + e.getComponent().asAttributeBase()
					                        .getAttribute(String.valueOf(AngularAttributes.ngDisabled));
				}
				e.getComponent().asAttributeBase()
				 .addAttribute(String.valueOf(AngularAttributes.ngDisabled), disabledOn.trim());
			}
		}
	}

	@Override
	public void onCall(Event<?, ?> e)
	{

	}
}
