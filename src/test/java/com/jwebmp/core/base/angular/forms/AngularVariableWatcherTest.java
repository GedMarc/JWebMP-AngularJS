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

package com.jwebmp.core.base.angular.forms;

import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.AngularChangeEvent;
import com.jwebmp.core.base.angular.AngularClientVariableWatcher;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.testing.BaseTest;
import org.junit.jupiter.api.Test;

public class AngularVariableWatcherTest
		extends BaseTest
{
	@Test
	public void test()
	{
		GuiceContext.get(AngularPageConfigurator.class)
		            .getAngularWatchers()
		            .add(
				            new AngularClientVariableWatcher("watchVariable", "variable.name", AngularChangeEventClass.class)
		                );
		System.out.println();
	}

	public class AngularChangeEventClass
			extends AngularChangeEvent<AngularChangeEventClass>
	{

		@Override
		public void onChange(AjaxCall call, AjaxResponse response)
		{

		}
	}
}
