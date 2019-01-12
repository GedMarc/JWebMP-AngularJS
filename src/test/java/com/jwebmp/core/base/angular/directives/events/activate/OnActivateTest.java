package com.jwebmp.core.base.angular.directives.events.activate;

import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.events.activate.ActivateAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnActivateTest
{

	@Test
	void onCall()
	{
		Div d = new Div();
		d.addEvent(new ActivateAdapter(d)
		{
			@Override
			public void onActivate(AjaxCall call, AjaxResponse response)
			{

			}
		});
		System.out.println(d.toString(0));
		assertTrue(d.toString(0)
		            .contains("ng-activate="));

	}
}
