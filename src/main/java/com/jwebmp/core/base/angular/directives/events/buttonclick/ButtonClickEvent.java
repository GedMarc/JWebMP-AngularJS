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
package com.jwebmp.core.base.angular.directives.events.buttonclick;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.events.buttonclick.ButtonClickAdapter;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;

/**
 * This event is triggered when a button is clicked.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "Button Event",
		description = "Server Side Event for Button Click Event.",
		url = "https://www.armineasy.com/JWebSwing",
		wikiUrl = "https://github.com/GedMarc/JWebMP/wiki")
public abstract class ButtonClickEvent<J extends ButtonClickEvent<J>>
		extends ButtonClickAdapter<J>
{
	private ButtonClickDirective directive;

	/**
	 * This event is triggered when a button is clicked.
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public ButtonClickEvent(Component component)
	{
		super(component);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	@Override
	public void preConfigure()
	{
		if (getComponent() != null)
		{
			getComponent().addAttribute(AngularAttributes.ngButtonClick,
			                            StaticStrings.STRING_ANGULAR_EVENT_START + renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
		super.preConfigure();
	}

	/**
	 * Returns this directive
	 *
	 * @return
	 */
	@NotNull
	public ButtonClickDirective getDirective()
	{
		if (directive == null)
		{
			setDirective(new ButtonClickDirective());
		}
		return directive;
	}

	/**
	 * Sets this directive
	 *
	 * @param directive
	 */
	public void setDirective(ButtonClickDirective directive)
	{
		this.directive = directive;
	}
}
