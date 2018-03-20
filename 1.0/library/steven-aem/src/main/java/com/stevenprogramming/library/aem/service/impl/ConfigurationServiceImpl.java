package com.stevenprogramming.library.aem.service.impl;

import com.stevenprogramming.library.aem.configuration.Configuration;
import com.stevenprogramming.library.aem.service.ConfigurationService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

/**
 *
 * @author steven.mendez
 * @since Oct 11 2017
 * @version 1.0
 */
@Component(immediate = true,
        service = ConfigurationService.class,
        configurationPid = "com.stevenprogramming.library.aem.service.impl.ConfigurationServiceImpl")
@Designate(ocd = Configuration.class)
public class ConfigurationServiceImpl implements ConfigurationService{
    
    @Override
    public String getNameDefault(){
        return "Steven";
    }

}
