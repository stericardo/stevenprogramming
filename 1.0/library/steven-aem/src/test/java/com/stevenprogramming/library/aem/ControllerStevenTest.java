package com.stevenprogramming.library.aem;

import com.adobe.cq.sightly.WCMBindings;
import com.day.cq.wcm.api.components.Component;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author steven.mendez
 * @since Oct 11 2017
 * @version 1.0
 */
public class ControllerStevenTest extends BaseControllerTest{
    
    @Test
    public void testController(){
        ControllerSteven controllerSteven = new ControllerSteven();
        controllerSteven.init(mockBindings);
    }

}
