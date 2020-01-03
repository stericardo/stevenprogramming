package com.stevenprogramming.liquibase.config;

import com.stevenprogramming.liquibase.services.PersonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
@RunWith( SpringRunner.class)
@WebAppConfiguration
@SpringJUnitConfig( classes = { SimpleTestConfig.class, ServiceConfig.class })
@DisplayName( "ConfigurationTest" )
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class BaseTest
{

    private static Logger logger = LoggerFactory.getLogger( BaseTest.class );

    public MockMvc mockMvc;

    @Autowired
    public PersonService personService;

    @Autowired
    public WebApplicationContext webApplicationContext;

    @BeforeAll
    static void setup(){
        logger.info( "\n\n####BeforeAll:::setup Setup Base Test \n" );
    }

    @BeforeEach
    void init(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        logger.info( "\n\n%%%% BeforeEach:::init Base Test \n" );
    }

}
