package com.stevenprogramming.library.core.ignore.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author steven.mendez
 * @since Sep 29 2017
 * @version 1.0
 */
public class ClassLoaderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassLoaderTest.class);
    
    public static void main(String[] args){
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        ClassLoader classLoader =classLoaderTest.getClass().getClassLoader();
        if(classLoader == null){
            LOGGER.info("Is null classLoader");
        }
        
        String test = "test";
        
    }
}
