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
package com.jwebmp.core.base.angular.directives.events.selected;

import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.html.Option;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.events.selected.SelectedAdapter;
import com.jwebmp.core.utilities.StaticStrings;

/**
 * Sets the selected attribute on the element, if the expression inside ngSelected is truthy.
 * <p>
 * A special directive is necessary because we cannot use interpolation inside the selected attribute. See the interpolation guide for more info.
 *
 * @author Marc Magon
 */
public abstract class SelectedEvent<J extends SelectedEvent<J>>
		extends SelectedAdapter<J>
		implements GlobalEvents
{
	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public SelectedEvent(Option component)
	{
		super(component);
	}

	/**
	 * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
	 */
	@Override
	public void preConfigure()
	{
		if (getComponent() != null)
		{

			getComponent().addAttribute(AngularAttributes.ngSelected,
			                            StaticStrings.STRING_ANGULAR_EVENT_START + renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}
		super.preConfigure();
	}

}
