package com.stevenprogramming.library.core.osgi.services;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 *
 * @author steven.mendez
 * @since Aug 04 2017
 * @version 1.0
 */
@Component(immediate = true)
@Service(value = MegaMenuService.class)
public class MegaMenuServiceImpl implements MegaMenuService {

}
