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
package com.jwebmp.core.base.angular.directives.events.drop;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.events.drop.DropAdapter;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "DropEvent",
		description = "Server Side Event for Drop",
		url = "https://www.armineasy.com/JWebSwing",
		wikiUrl = "https://github.com/GedMarc/JWebMP/wiki")
public abstract class DropEvent<J extends DropEvent<J>>
		extends DropAdapter<J>
		implements GlobalEvents
{
	private DropDirective directive;

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public DropEvent(Component component)
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

	/**
	 * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
	 */
	@Override
	public void preConfigure()
	{
		if (getComponent() != null)
		{

			getComponent().addAttribute(AngularAttributes.ngDrop, StaticStrings.STRING_ANGULAR_EVENT_START + renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
		super.preConfigure();
	}

	/**
	 * Returns the angular directive associated with the right click event
	 *
	 * @return
	 */
	@NotNull
	public DropDirective getDirective()
	{
		if (directive == null)
		{
			directive = new DropDirective();
		}
		return directive;
	}

	/**
	 * Sets the right click angular event
	 *
	 * @param directive
	 */
	public void setDirective(DropDirective directive)
	{
		this.directive = directive;
	}
}
