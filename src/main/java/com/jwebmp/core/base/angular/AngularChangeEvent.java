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

package com.jwebmp.core.base.angular;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.directives.events.change.ChangeEvent;

public abstract class AngularChangeEvent<J extends AngularChangeEvent<J>>
		extends ChangeEvent<J>
{
	public AngularChangeEvent()
	{
		this(null);
	}

	public AngularChangeEvent(Component component)
	{
		super(component);
	}

	public AngularChangeDto getChangeDto(AjaxCall call)
	{
		return call.getVariable("angularchangeeventobject")
		           .as(AngularChangeDto.class);
	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		onChange(call, response);
		super.fireEvent(call, response);
	}

	@Override
	public abstract void onChange(AjaxCall call, AjaxResponse response);
}
