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
package com.jwebmp.core.base.angular;

import com.google.inject.Singleton;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.servlets.JWDefaultServlet;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.interception.services.DataCallIntercepter;

import static com.jwebmp.interception.JWebMPInterceptionBinder.*;

/**
 * @author GedMarc
 */
@Singleton
public class AngularDataVariables
		extends JWDefaultServlet
{
	
	
	@Override
	public void perform()
	{
		Page<?> page = GuiceContext.inject()
		                           .getInstance(Page.class);
		
		for (DataCallIntercepter<?> dataCallIntercepter : GuiceContext.get(DataCallInterceptorKey))
		{
			dataCallIntercepter.intercept(GuiceContext.get(AjaxCall.class), GuiceContext.get(AjaxResponse.class));
		}
		
		StringBuilder output = GuiceContext.get(AngularPageConfigurator.class)
		                                   .renderAngularJavascript(page);
		writeOutput(output, StaticStrings.HTML_HEADER_JAVASCRIPT, StaticStrings.UTF_CHARSET);
	}
}
