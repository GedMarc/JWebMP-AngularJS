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

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.testing.BaseTest;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class AngularFeatureTest
		extends BaseTest
{

	public AngularFeatureTest()
	{
	}

	@Test
	public void testSomeMethod()
	{
		Page<?> p = new Page();
		p.getBody()
		 .add("Hello");
		
		System.out.println(p.toString(0));
	}

	@Test
	public void testDirectivesServiceLocator()
	{
		StringBuilder sb = new StringBuilder();
		AngularFeature af = new AngularFeature(new Page());
		af.configureTemplateVariables();
		sb.append(FileTemplates.renderTemplateScripts("jwangular"));

		System.out.println(sb);
	}

}
