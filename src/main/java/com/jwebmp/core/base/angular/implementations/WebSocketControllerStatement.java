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

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.base.angular.services.IAngularControllerScopeStatement;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.websockets.services.IWebSocketAuthDataProvider;

import java.util.ServiceLoader;
import java.util.Set;

/**
 * Registers the moment angular module as available for the application
 *
 * @author GedMarc
 * @version 1.0
 * @since Oct 4, 2016
 */
public class WebSocketControllerStatement
		implements IAngularControllerScopeStatement<WebSocketControllerStatement>
{
	public WebSocketControllerStatement()
	{
		//No config Required
	}

	@Override
	public StringBuilder getStatement()
	{
		StringBuilder template = FileTemplates.getFileTemplate(WebSocketControllerStatement.class, "JW_SCOPE_INSERTIONS", "websockets.js");
		StringBuilder replaceable = new StringBuilder();
		Set<IWebSocketAuthDataProvider> setss = GuiceContext.instance()
		                                                    .getLoader(IWebSocketAuthDataProvider.class, ServiceLoader.load(IWebSocketAuthDataProvider.class));
		for (IWebSocketAuthDataProvider a : setss)
		{
			if (!a.enabled())
			{
				continue;
			}
			replaceable.append(a.getJavascriptToPopulate());
		}
		template = new StringBuilder(template.toString()
		                                     .replace("WS_AUTH_DATA_PROVIDER_LOAD;", replaceable.toString()));
		return template;
	}

	@Override
	public String getReferenceName()
	{
		return "WebSocketControllerStatement";
	}

	@Override
	public String renderFunction()
	{
		return null;
	}

	@Override
	public boolean enabled()
	{
		return true;
	}
}
