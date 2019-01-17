/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.angular.modules;

import com.jwebmp.core.base.angular.AngularReferenceBase;
import com.jwebmp.core.base.angular.services.IAngularModule;

import javax.validation.constraints.NotNull;

/**
 * Is an angular module
 *
 * @author GedMarc
 * @since 24 Jul 2016
 */
public abstract class AngularModuleBase<J extends AngularModuleBase<J>>
		extends AngularReferenceBase<J>
		implements IAngularModule<J>
{
	/**
	 * Constructs a module with this name that always sorts default
	 *
	 * @param moduleName
	 * 		This modules name
	 */
	public AngularModuleBase(@NotNull String moduleName)
	{
		super(moduleName);
	}

}
