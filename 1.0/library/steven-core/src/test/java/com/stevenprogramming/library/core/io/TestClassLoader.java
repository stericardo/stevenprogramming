/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenprogramming.library.core.io;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author steven.mendez
 */
public class TestClassLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestClassLoader.class);

    public TestClassLoader() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ClassLoaderTest.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ClassLoaderTest.main(args);
    }

    @Test
    public void testClassLoader() {
        ClassLoaderTest classLoaderTest = mock(ClassLoaderTest.class);
        ClassLoader classLoader = classLoaderTest.getClass().getClassLoader();
        if (classLoader == null) {
            LOGGER.info("Is null classLoader");
        } else {
            LOGGER.info("Is NOT NULL classLoader");
        }
        
        String test = "test";
    }

}
