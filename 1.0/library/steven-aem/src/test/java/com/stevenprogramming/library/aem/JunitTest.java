package com.stevenprogramming.library.aem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author steven.mendez
 * @since Oct 11 2017
 * @version 1.0
 */
public class JunitTest {

    @Test
    public void testAdd() {
        ControllerSteven junitHelloWorld = new ControllerSteven();
        junitHelloWorld.getName();
        ControllerSteven mockedControllerSteven = mock(ControllerSteven.class);
        
        assertEquals("Manda webo fallo el test ","Pablos", "Pablos");
    }

}
