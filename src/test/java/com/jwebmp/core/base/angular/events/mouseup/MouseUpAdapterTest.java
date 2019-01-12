package com.jwebmp.core.base.angular.events.mouseup;

import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.events.mouseup.MouseUpAdapter;
import com.jwebmp.testing.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MouseUpAdapterTest
		extends BaseTest
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		MouseUpAdapter aa = new MouseUpAdapter(test)
		{
			@Override
			public void onMouseUp(AjaxCall call, AjaxResponse response)
			{

			}
		};
		test.addEvent(aa.setID("test"));
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-mouseup=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com_jwebmp_core_base_angular_events_mouseup_MouseUpAdapterTest$1');\"></div>",
				test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");

		MouseUpAdapter aa = new MouseUpAdapter(test)
		{
			@Override
			public void onMouseUp(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));

	}
}
