package com.stevenprogramming.library.aem;

import com.stevenprogramming.library.aem.service.ConfigurationService;
import com.stevenprogramming.library.aem.service.impl.ConfigurationServiceImpl;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.osgi.service.component.ComponentContext;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author steven.mendez
 * @since Oct 11 2017
 * @version 1.0
 */
//@RunWith(PowerMockRunner.class)
public class BaseControllerPowerMockTest {

    //@InjectMocks
    //private ConfigurationService mockSiteConfigService = new ConfigurationServiceImpl();

    @Before
    public void setUp() throws Exception {
        //Dictionary<String, Object> props = new Hashtable<String, Object>();
        //props.put("api.end.point.baseurl", "/api");
        //ComponentContext context = PowerMockito.mock(ComponentContext.class);
        //Method activate = mockSiteConfigService.getClass().getDeclaredMethod("activate", ComponentContext.class);
        //activate.setAccessible(true);
        //PowerMockito.when(context.getProperties()).thenReturn(props);
        //activate.invoke(mockSiteConfigService, context);

    }

}
