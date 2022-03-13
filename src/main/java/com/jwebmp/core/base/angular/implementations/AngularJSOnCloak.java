package com.jwebmp.core.base.angular.implementations;

import com.jwebmp.core.base.ComponentDataBindingBase;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.databind.IOnDataBindCloak;
import com.guicedee.guicedinjection.json.StaticStrings;

public class AngularJSOnCloak
		implements IOnDataBindCloak
{
	@Override
	public void onCloak(ComponentDataBindingBase component)
	{
		component.addAttribute(AngularAttributes.ngCloak, StaticStrings.STRING_EMPTY);
		
	}
}
