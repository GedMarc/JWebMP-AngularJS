package com.jwebmp.core.base.angular.implementations;

import com.jwebmp.core.base.ComponentDataBindingBase;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.databind.IOnDataBind;

import jakarta.validation.constraints.NotNull;

public class AngularJSOnBind
		implements IOnDataBind<AngularJSOnBind>
{
	@Override
	public void onBind(@NotNull ComponentDataBindingBase component, String bindingValue)
	{
		AngularPageConfigurator.setRequired(true);

		if (Paragraph.class.isAssignableFrom(component.getClass()))
		{
			configureForParagraph((Paragraph) component, bindingValue);
		}
		else if (Input.class.isAssignableFrom(component.getClass()))
		{
			configureForInput((Input) component, bindingValue);
		}
		else
		{
			component.addAttribute(AngularAttributes.ngBind, bindingValue);
		}
	}

	private void configureForParagraph(Paragraph paragraph, String bindingValue)
	{
		AngularPageConfigurator.setRequired(true);
		if (bindingValue.contains("{{"))
		{
			paragraph.setText(paragraph.getText(0) + bindingValue);
		}
		else
		{
			paragraph.setText(paragraph.getText(0) + "{{" + bindingValue + "}}");
		}
	}

	private void configureForInput(Input input, String bindingValue)
	{
		AngularPageConfigurator.setRequired(true);
		if (bindingValue != null)
		{
			input.addAttribute(AngularAttributes.ngModel, bindingValue);
		}
		else
		{
			input.removeAttribute(AngularAttributes.ngModel.toString());
		}
	}
}
