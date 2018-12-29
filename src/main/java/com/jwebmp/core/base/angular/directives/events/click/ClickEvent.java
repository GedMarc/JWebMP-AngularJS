/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.core.base.angular.directives.events.click;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.BodyEvents;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.html.interfaces.events.ParagraphEvents;
import com.jwebmp.core.events.click.ClickAdapter;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.utilities.StaticStrings;

/**
 * Logger for the Component
 */
@ComponentInformation(name = "Click Event",
		description = "Server Side Event for Click.",
		url = "https://www.armineasy.com/JWebSwing",
		wikiUrl = "https://github.com/GedMarc/JWebMP/wiki")
public abstract class ClickEvent<J extends ClickEvent<J>>
		extends ClickAdapter<J>
		implements ParagraphEvents<GlobalFeatures, J>, BodyEvents<GlobalFeatures, J>, GlobalEvents
{
	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public ClickEvent(ComponentHierarchyBase component)
	{
		super(component);
	}

	@Override
	public void preConfigure()
	{
		if (getComponent() != null)
		{
			String command = //"jwCntrl.jw.isLoading || " +
					StaticStrings.STRING_ANGULAR_EVENT_START +
					renderVariables() +
					StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON;

			if (getComponent().getAttribute(AngularAttributes.ngClick) == null)
			{
				getComponent().addAttribute(AngularAttributes.ngClick, command);
			}
			else
			{
				getComponent().addAttribute(AngularAttributes.ngClick, getComponent().getAttribute(AngularAttributes.ngClick) + command);
			}

			if (getComponent().getAttribute(AngularAttributes.ngDisabled) == null)
			{
				getComponent().addAttribute(AngularAttributes.ngDisabled, "jwCntrl.jw.isLoading");
			}
			else if (!"jwCntrl.jw.isLoading".equals(getComponent().getAttribute(AngularAttributes.ngDisabled)))
			{
				String disabledOn = "jwCntrl.jw.isLoading ";
				if (!"".equals(getComponent().getAttribute(AngularAttributes.ngDisabled)) && !(getComponent().getAttribute(AngularAttributes.ngDisabled) == null))
				{
					disabledOn += " || " + getComponent().getAttribute(AngularAttributes.ngDisabled);
				}
				getComponent().addAttribute(AngularAttributes.ngDisabled, disabledOn.trim());
			}
		}
		super.preConfigure();
	}

}
