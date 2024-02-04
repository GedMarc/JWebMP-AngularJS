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

import com.google.inject.servlet.ServletModule;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.jwebmp.core.annotations.PageConfiguration;
import com.jwebmp.core.base.angular.servlets.AngularServlet;
import com.jwebmp.core.implementations.JWebMPJavaScriptDynamicScriptRenderer;
import com.jwebmp.core.implementations.JWebMPSiteBinder;
import com.jwebmp.core.services.IPage;
import lombok.extern.java.Log;

import java.util.Map;
import java.util.logging.Level;

import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * @author GedMarc
 * @version 1.0
 * @since 20 Dec 2016
 */
@Log
public class AngularJSSiteBinder
	extends ServletModule
		implements IGuiceModule<AngularJSSiteBinder>
{
	
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
	 * @param module of type GuiceSiteInjectorModule
	 */
	@Override
	public void configureServlets()
	{
		for (Map.Entry<PageConfiguration, IPage<?>> entry : JWebMPSiteBinder.getPageConfigurations()
		                                                                    .entrySet())
		{
			PageConfiguration pc = entry.getKey();
			IPage<?> page = entry.getValue();
			StringBuilder url = new StringBuilder(pc.url());
			url = new StringBuilder(pc.url()
			                          .substring(0, pc.url()
			                                          .length() - 1) + ANGULAR_SCRIPT_LOCATION);
			
			url.insert(0, "(")
			   .append(QUERY_PARAMETERS_REGEX)
			   .append(")");
			
			serveRegex(url.toString())
			      .with(AngularServlet.class);
			log.log(Level.FINE, "Serving Angular at {0}", url);
		}
		
		
		serveRegex("(" + com.jwebmp.core.utilities.StaticStrings.ANGULAR_SCRIPT_LOCATION + ")" + StaticStrings.QUERY_PARAMETERS_REGEX)
		      .with(AngularServlet.class);
		AngularJSSiteBinder.log.log(Level.FINE, "Serving Angular JavaScript at {0}", com.jwebmp.core.utilities.StaticStrings.ANGULAR_SCRIPT_LOCATION);
		
		JWebMPJavaScriptDynamicScriptRenderer.renderJavascript = false;
		
	}
}
