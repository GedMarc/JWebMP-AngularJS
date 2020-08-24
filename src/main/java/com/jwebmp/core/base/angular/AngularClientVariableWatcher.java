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

import com.jwebmp.core.databind.ClientVariableWatcher;
import com.jwebmp.core.events.change.ChangeAdapter;
import com.guicedee.guicedinjection.json.StaticStrings;

import javax.validation.constraints.NotNull;

/**
 * Denotes an angular variable to watch with an event class mapped
 */
public class AngularClientVariableWatcher
		extends ClientVariableWatcher
{

	/**
	 * Constructor ClientVariableWatcher creates a new ClientVariableWatcher instance.
	 *
	 * @param watchName
	 * 		of type String
	 * @param variableName
	 * 		of type String
	 * @param eventClass
	 * 		of type Class ? extends ChangeAdapter
	 */
	public AngularClientVariableWatcher(@NotNull String watchName, @NotNull String variableName, @NotNull Class<? extends ChangeAdapter<?>> eventClass)
	{
		super(watchName, variableName, eventClass);
	}

	/**
	 * Method onClientVariableRequest ...
	 *
	 * @param watchName
	 * 		of type String
	 * @param variableName
	 * 		of type String
	 * @param eventClass
	 * 		of type Class<? extends ChangeAdapter<?>>
	 *
	 * @return String
	 */
	@Override
	public String onClientVariableRequest(@NotNull String watchName, @NotNull String variableName, @NotNull Class<? extends ChangeAdapter<?>> eventClass)
	{
		String returnable = "$scope.$watch('" +
		                    variableName +
		                    "'," +
		                    "function(newValue,oldValue){" +
		                    "if (newValue == oldValue){" +
		                    "}" +
		                    "else " +
		                    "{" +
		                    "$scope.angularchangeeventobject= {'old':oldValue,'new':newValue};" +
		                    "jw.env" +
		                    ".controller" +
		                    ".jw.isLoading || jw.env" +
		                    ".controller.perform(null" +
		                    "," +
		                    "['angularchangeeventobject']," +
		                    "'AngularWatchEvent'," +
		                    "'" +
		                    eventClass.getCanonicalName()
		                              .replace(
				                              StaticStrings.CHAR_DOT,
				                              StaticStrings.CHAR_UNDERSCORE) +
		                    "');";
		returnable += "}" + "});" + StaticStrings.STRING_NEWLINE_TEXT;
		return returnable;
	}
}
