package com.stevenprogramming.liquibase.config;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
public class ConfigurationTest extends BaseTest{

    @Value("${subscriber:admin@example.com}")
    private String theSubscriber;

    private static Logger logger = LoggerFactory.getLogger( ConfigurationTest.class );

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

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

}
