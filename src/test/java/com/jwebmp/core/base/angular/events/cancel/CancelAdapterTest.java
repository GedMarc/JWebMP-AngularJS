package com.jwebmp.core.base.angular.events.cancel;

import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.events.cancel.CancelAdapter;
import com.jwebmp.testing.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CancelAdapterTest
		extends BaseTest
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		CancelAdapter aa = new CancelAdapter(test)
		{
			@Override
			public void onCancel(AjaxCall call, AjaxResponse response)
			{

			}
		};
		test.addEvent(aa.setID("test"));
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-cancel=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com_jwebmp_core_base_angular_events_cancel_CancelAdapterTest$1');" +
				"\"></div>",
				test.toString(0));
	}

}
