package com.jwebmp.core.base.angular.implementations;

import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.testing.BaseTest;
import com.jwebmp.testing.services.ITestInstanceDestroyService;
import com.jwebmp.testing.services.ITestInstanceInitializerService;
import com.jwebmp.testing.services.ITestInstanceResetService;

public class AngualarTestConfig
		implements ITestInstanceResetService, ITestInstanceDestroyService, ITestInstanceInitializerService,
				           IDefaultService<AngualarTestConfig>
{
	@Override
	public void reset(BaseTest testInstance)
	{
		destroy(testInstance);
		initialize(testInstance);
	}

	@Override
	public void destroy(BaseTest testInstance)
	{
		AngularPageConfigurator.setEnabled(false);
	}

	@Override
	public void initialize(BaseTest testInstance)
	{
		AngularPageConfigurator.setEnabled(false);
	}
}
