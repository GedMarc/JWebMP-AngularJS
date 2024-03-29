package com.jwebmp.core.base.angular.implementations;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.jwebmp.core.base.angular.services.*;

import java.util.ServiceLoader;
import java.util.Set;

@SuppressWarnings({"Convert2Diamond", "MissingFieldJavaDoc", "rawtypes", "unchecked"})
public class AngularJSServicesBindings
	extends AbstractModule
		implements IGuiceModule<AngularJSServicesBindings>
{

	public static final Key<Set<IAngularDirective>> AngularDirectivesKey = Key.get(new TypeLiteral<Set<IAngularDirective>>() {});
	public static final Key<Set<IAngularControllerScopeStatement>> AngularControllerScopeStatementsKey = Key.get(new TypeLiteral<Set<IAngularControllerScopeStatement>>() {});
	public static final Key<Set<IAngularModule>> AngularModulesKey = Key.get(new TypeLiteral<Set<IAngularModule>>() {});
	public static final Key<Set<IAngularConfigurationScopeStatement>> AngularConfigurationScopeStatementKey = Key.get(
			new TypeLiteral<Set<IAngularConfigurationScopeStatement>>() {});
	public static final Key<Set<IAngularConfiguration>> AngularConfigurationKey = Key.get(new TypeLiteral<Set<IAngularConfiguration>>() {});
	public static final Key<Set<IAngularController>> AngularControllerKey = Key.get(new TypeLiteral<Set<IAngularController>>() {});
	public static final Key<Set<IAngularFactory>> AngularFactoryKey = Key.get(new TypeLiteral<Set<IAngularFactory>>() {});

	@Override
	public void configure()
	{
		bind(AngularJSServicesBindings.AngularDirectivesKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularDirective.class, ServiceLoader.load(IAngularDirective.class)))
		      .in(Singleton.class);
		bind(AngularJSServicesBindings.AngularControllerScopeStatementsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularControllerScopeStatement.class, ServiceLoader.load(IAngularControllerScopeStatement.class)))
		      .in(Singleton.class);
		bind(AngularJSServicesBindings.AngularModulesKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularModule.class, ServiceLoader.load(IAngularModule.class)))
		      .in(Singleton.class);
		bind(AngularJSServicesBindings.AngularConfigurationScopeStatementKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularConfigurationScopeStatement.class, ServiceLoader.load(IAngularConfigurationScopeStatement.class)))
		      .in(Singleton.class);
		bind(AngularJSServicesBindings.AngularConfigurationKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularConfiguration.class, ServiceLoader.load(IAngularConfiguration.class)))
		      .in(Singleton.class);
		bind(AngularJSServicesBindings.AngularControllerKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularController.class, ServiceLoader.load(IAngularController.class)))
		      .in(Singleton.class);
		bind(AngularJSServicesBindings.AngularFactoryKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularFactory.class, ServiceLoader.load(IAngularFactory.class)))
		      .in(Singleton.class);
	}
}
