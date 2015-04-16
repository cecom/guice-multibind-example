package com.mycompany.app.plugin2;

import com.google.inject.multibindings.Multibinder;
import com.mycompany.app.api.PropertyResolver;
import com.mycompany.app.api.PropertyResolverModule;

public class PropertyFileModule extends PropertyResolverModule {

	@Override
	public void configure() {
		Multibinder<PropertyResolver> resolveBinder = Multibinder.newSetBinder(binder(), PropertyResolver.class);
		resolveBinder.addBinding().to(PropertyFileResolver.class);

	}

	@Override
	public String propertyResolverId() {
		return "propertyFile";
	}
}
