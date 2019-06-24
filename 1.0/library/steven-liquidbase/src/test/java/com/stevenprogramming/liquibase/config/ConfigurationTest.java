package com.stevenprogramming.liquibase.config;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@RunWith( SpringRunner.class)
@SpringJUnitConfig( classes = { SimpleTestConfig.class, ServiceConfig.class })
@DisplayName( "ConfigurationTest" )
@ActiveProfiles("test")
public class ConfigurationTest {

    @Value("${subscriber:admin@example.com}")
    private String theSubscriber;

    private static Logger logger = LoggerFactory.getLogger( ConfigurationTest.class );

    @BeforeAll
    static void setup(){
        logger.info( "\n\n#### Running \n\n\n" );
    }

    @BeforeEach
    void init(){
        logger.info( "\n\n%%%% BeforeEach \n\n\n" );
    }

    @Test
    @DisplayName( "Context Test" )
    public void contextTest(){

        logger.info( "\n\n ----Running contextTest ---- \n\n\n" );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Configuration.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String name, String last) {
        //Values one by one
        assertNotNull(name);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }

}
