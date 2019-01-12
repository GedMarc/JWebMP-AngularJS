package com.jwebmp.core.base.angular.events.selected;

import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Option;
import com.jwebmp.core.events.selected.SelectedAdapter;
import com.jwebmp.testing.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectedAdapterTest
		extends BaseTest
{
	@Test
	public void test()
	{
		Option test = new Option<>("optionValue");
		test.setID("test");
		SelectedAdapter aa = new SelectedAdapter(test)
		{
			@Override
			public void onSelected(AjaxCall call, AjaxResponse response)
			{

			}
		};
		test.addEvent(aa.setID("test"));
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<option label=\"optionValue\" value=\"optionValue\" id=\"test\" ng-selected=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com_jwebmp_core_base_angular_events_selected_SelectedAdapterTest$1');\">optionValue</option>",
				test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Option test = new Option<>("optionValue");
		test.setID("test");

		SelectedAdapter aa = new SelectedAdapter(test)
		{
			@Override
			public void onSelected(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));

	}

}
