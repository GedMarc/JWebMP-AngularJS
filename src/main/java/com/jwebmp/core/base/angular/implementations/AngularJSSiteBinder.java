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
package com.jwebmp.core.base.angular.implementations;

import com.jwebmp.core.base.angular.servlets.AngularDataServlet;
import com.jwebmp.core.base.angular.servlets.AngularServlet;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.guicedservlets.services.GuiceSiteInjectorModule;
import com.guicedee.guicedservlets.services.IGuiceSiteBinder;
import com.guicedee.logger.LogFactory;

import java.util.logging.Level;

import static com.jwebmp.core.utilities.StaticStrings.ANGULAR_DATA_LOCATION;

/**
 * @author GedMarc
 * @version 1.0
 * @since 20 Dec 2016
 */
public class AngularJSSiteBinder
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{
	/**
	 * Field log
	 */
	private static final java.util.logging.Logger log = LogFactory.getLog("AngularJSSiteBinder");

	/**
	 * Gets the angular script location
	 *
	 * @return The Angular Scripts location
	 */
	public static String getAngularScriptLocation()
	{
		return com.jwebmp.core.utilities.StaticStrings.ANGULAR_SCRIPT_LOCATION;
	}

	/**
	 * Returns the angular data location
	 *
	 * @return The Angular Data Scripts
	 */
	public static String getAngularDataLocation()
	{
		return ANGULAR_DATA_LOCATION;
	}

	/**
	 * Method onBind ...
	 *
	 * @param module
	 * 		of type GuiceSiteInjectorModule
	 */
	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		module.serveRegex$("(" + ANGULAR_DATA_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AngularDataServlet.class);
		AngularJSSiteBinder.log.log(Level.FINE, "Serving Angular Data at " + ANGULAR_DATA_LOCATION);

		module.serveRegex$("(" + com.jwebmp.core.utilities.StaticStrings.ANGULAR_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AngularServlet.class);
		AngularJSSiteBinder.log.log(Level.FINE, "Serving Angular JavaScript at {0}", com.jwebmp.core.utilities.StaticStrings.ANGULAR_SCRIPT_LOCATION);

	}
}
