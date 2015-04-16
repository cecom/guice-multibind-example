An example of guice, multibind and serviceloader.

Call the App.class with one of the following id parameters:
 - app propertyFile
 - app commandLine
 - app propertyFile commandLine
 - app commandLine propertyFile

The parameters are ID's for "PropertyResolver" implementations, which will be loaded at runtime and will be executed in the given order.

