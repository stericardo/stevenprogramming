package com.stevenprogramming.library.aem;

import com.adobe.cq.sightly.WCMBindings;
import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.contentsync.handler.util.RequestResponseFactory;
import com.day.cq.wcm.api.components.Component;
import com.day.cq.wcm.api.components.ComponentContext;
import com.day.cq.wcm.api.components.EditContext;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Resource;
import javax.jcr.ValueFormatException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.script.Bindings;
import javax.script.SimpleBindings;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.testing.mock.osgi.MockOsgi;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.osgi.framework.BundleContext;

/**
 *
 * @author steven.mendez
 * @since Oct 11 2017
 * @version 1.0
 */
public class BaseControllerTest {

    protected Bindings mockBindings;
    protected ResourceResolver mockResourceResolver;
    
    @Before
    public void setUp() throws ConstraintViolationException, ValueFormatException {

        mockBindings = mock(SimpleBindings.class);
        
        SlingScriptHelper mockSling = mock(SlingScriptHelper.class);
        mockBindings.put(SlingBindings.SLING, mockSling);
        when(mockBindings.get(SlingBindings.SLING)).thenReturn(mockSling);

        EditContext mockEditContext = mock(EditContext.class);
        when(mockBindings.get(WCMBindings.EDIT_CONTEXT)).thenReturn(mockEditContext);

        ComponentContext mockComponentContext = mock(ComponentContext.class);
        when(mockBindings.get(WCMBindings.COMPONENT_CONTEXT)).thenReturn(mockComponentContext);

        ValueMap mockValueMapProperties = mock(ValueMap.class);
        when(mockBindings.get(WCMBindings.PROPERTIES)).thenReturn(mockValueMapProperties);

        ValueMap mockInheritedPageProperties = mock(ValueMap.class);
        when(mockBindings.get(WCMBindings.INHERITED_PAGE_PROPERTIES)).thenReturn(mockInheritedPageProperties);

        Properties mockProperties = mock(Properties.class);
        when(mockBindings.get(Properties.class)).thenReturn(mockProperties);
        
        mockResourceResolver = mock(ResourceResolver.class);
        
    }

}
