package com.stevenprogramming.spring.boot.poc.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BeanForAutowiredAndPostConstruct {

    private static final Logger LOGGER = LogManager.getLogger(BeanForAutowiredAndPostConstruct.class.getName());

    private Map<Integer, Integer> map;

    @PostConstruct
    public void init(){
        LOGGER.info("Init - PostConstruct " + this.getClass().getName());
        map = new HashMap<>();
    }

    public void fillMap(Integer value){
        LOGGER.info("fillMap " + this.getClass().getName() + " map is null ? " + (map == null));
        map.put(value, value);
    }
}
