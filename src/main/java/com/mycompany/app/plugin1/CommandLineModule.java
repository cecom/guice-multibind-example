package com.mycompany.app.plugin1;

import com.google.inject.multibindings.Multibinder;
import com.mycompany.app.api.PropertyResolver;
import com.mycompany.app.api.PropertyResolverModule;

public class CommandLineModule extends PropertyResolverModule {

	@Override
	public void configure() {
		Multibinder<PropertyResolver> resolveBinder = Multibinder.newSetBinder(binder(), PropertyResolver.class);
		resolveBinder.addBinding().to(CommandLineResolver.class);
	}

	@Override
	public String propertyResolverId() {
		return "commandLine";
	}
}
