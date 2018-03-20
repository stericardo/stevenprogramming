package com.stevenprogramming.library.aem.configuration;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 *
 * @author steven.mendez
 * @version 1.0
 * @since October 11, 2017
 */
@ObjectClassDefinition(name = "Hello World Configuration",
        description = "The configuration for the hello world component.")
public @interface Configuration {

    @AttributeDefinition(name = "Welcome Message", description = "Default description")
    String message() default "Default Message";

}
