package com.stevenprogramming.liquibase.config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
@RunWith( SpringRunner.class)
@SpringJUnitConfig( classes = { SimpleTestConfig.class, ServiceConfig.class })
@DisplayName( "ConfigurationTest" )
@ActiveProfiles("test")
public class BaseTest
{

    private static Logger logger = LoggerFactory.getLogger( BaseTest.class );

    @BeforeAll
    static void setup(){
        logger.info( "\n\n####BeforeAll:::setup Setup Base Test \n" );
    }

    @BeforeEach
    void init(){
        logger.info( "\n\n%%%% BeforeEach:::init Base Test \n" );
    }

}
