package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.mycompany.app.api.PropertyResolver;
import com.mycompany.app.api.PropertyResolverModule;

public class App
{
	private Set<PropertyResolver> resolvers;

	@Inject
	public App(Set<PropertyResolver> resolver) {
		this.resolvers = resolver;
	}

	public void doSomething() {
		for (PropertyResolver resolver : resolvers) {
			System.out.println(resolver.resolve("foobar"));
		}

	}

	public static void main(String[] args) {

		List<PropertyResolverModule> moduleList = new ArrayList<PropertyResolverModule>();
		for (String resolver : args) {
			moduleList.add(getModuleForId(resolver));
		}

		Injector injector = Guice.createInjector(moduleList);
		injector.getInstance(App.class).doSomething();
	}

	private static PropertyResolverModule getModuleForId(String resolver) {
		for (PropertyResolverModule module : ServiceLoader.load(PropertyResolverModule.class)) {
			if (module.propertyResolverId().equals(resolver)) {
				return module;
			}
		}
		throw new IllegalArgumentException("Resolver [" + resolver + "] not found!");
	}

}
