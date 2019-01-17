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
package com.jwebmp.core.base.angular.controllers;

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.base.angular.AngularReferenceBase;
import com.jwebmp.core.base.angular.services.IAngularController;
import com.jwebmp.core.base.angular.services.IAngularControllerScopeStatement;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;

import javax.validation.constraints.NotNull;
import java.util.Set;

import static com.jwebmp.core.base.angular.implementations.AngularJSServicesBindings.*;

/**
 * Maps to the angular function of right click
 *
 * @author GedMarc
 * @since 25 Jun 2016
 */
public class JWAngularController
		extends AngularReferenceBase
		implements IAngularController<JWAngularController>
{


	/**
	 * Constructs a new right click directive based on the angular object passed in
	 */
	public JWAngularController()
	{
		super("jwController");
	}

	/**
	 * Renders the right click directive from the JavaScript file
	 *
	 * @return
	 */
	@Override
	@NotNull
	public String renderFunction()
	{
		StringBuilder controllerOutput = FileTemplates.getFileTemplate(JWAngularController.class, "jwcontroller");
		if (controllerOutput == null)
		{
			throw new UnsupportedOperationException("Didn't find FileTemplate for Angular Controller Classes.");
		}
		String output = controllerOutput.toString();
		StringBuilder statementOutput = new StringBuilder();

		Set<IAngularControllerScopeStatement> loader = GuiceContext.get(AngularControllerScopeStatementsKey);
		for (IAngularControllerScopeStatement statement : loader)
		{
			if (!statementOutput.toString()
			                    .contains(statement.getStatement()))
			{
				statementOutput.append(statement.getStatement())
				               .append(StaticStrings.STRING_NEWLINE_TEXT);
			}
		}

		output = output.replace("JW_SCOPE_INSERTIONS;", statementOutput.toString());
		output = output.replace("JW_SCOPE_INSERTIONS", statementOutput.toString());
		return output;
	}


	/**
	 * If this page configurator is enabled
	 *
	 * @return if the configuration must run
	 */
	@Override
	public boolean enabled()
	{
		return true;
	}
}
