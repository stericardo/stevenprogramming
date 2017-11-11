package com.stevenprogramming.library.aem;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.scripting.SlingScriptHelper;

/**
 *
 * @author steven.mendez
 * @since Sep 22 2017
 * @version 1.0
 */
public class ControllerSteven extends WCMUsePojo{

    private String name;
    
    @Override
    public void activate() throws Exception {
        SlingScriptHelper slingScriptHelper = getSlingScriptHelper();
        if(null == slingScriptHelper){
        
        }
    }
    
    public String getName(){
        return name;
    }
    
}
