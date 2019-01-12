package com.jwebmp.core.base.angular.events.beforeactivate;

import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.events.beforeactivate.BeforeActivateAdapter;
import com.jwebmp.testing.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeforeActivateAdapterTest
		extends BaseTest
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		BeforeActivateAdapter aa = new BeforeActivateAdapter(test)
		{
			@Override
			public void onBeforeActivate(AjaxCall call, AjaxResponse response)
			{

			}
		};
		test.addEvent(aa.setID("test"));
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-before-activate=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com_jwebmp_core_base_angular_events_beforeactivate_BeforeActivateAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
