package com.stevenprogramming.spring.boot.poc.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class BeanTargetAutowiredAndPostConstruct {

    private static final Logger LOGGER = LogManager.getLogger(BeanTargetAutowiredAndPostConstruct.class.getName());

    @Autowired
    private BeanForAutowiredAndPostConstruct beanForAutowiredAndPostConstruct;

    @PostConstruct
    public void init(){
        LOGGER.info("Init - PostConstruct " + this.getClass().getName());
        fillMap(3);
    }

    public void fillMap(Integer value){
        beanForAutowiredAndPostConstruct.fillMap(value);
    }
}
