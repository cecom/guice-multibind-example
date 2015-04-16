package com.mycompany.app.plugin2;

import com.mycompany.app.api.PropertyResolver;

public class PropertyFileResolver implements PropertyResolver {

	public String resolve(String property) {
		return "Resolving property [" + property + "] with PropertyFileResolver";
	}

}
