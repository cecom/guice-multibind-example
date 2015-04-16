package com.mycompany.app.plugin1;

import com.mycompany.app.api.PropertyResolver;

public class CommandLineResolver implements PropertyResolver {

	public String resolve(String property) {
		return "Resolving property [" + property + "] with CommandLineResolver";
	}

}
