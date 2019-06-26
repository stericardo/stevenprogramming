package com.stevenprogramming.liquibase.services.impl;

import com.stevenprogramming.liquibase.config.BaseTest;
import com.stevenprogramming.liquibase.model.Person;
import com.stevenprogramming.liquibase.services.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */

public class PersonServiceImplTest extends BaseTest
{

    private static Logger logger = LoggerFactory.getLogger( PersonServiceImplTest.class );

    @Autowired
    PersonService personService;

    @Test
    @DisplayName( "Person creation Test SQL" )
    @SqlGroup( {
            @Sql(
                    value = "classpath:db/person-data.sql",
                    config = @SqlConfig( encoding = "utf-8", separator = ";", commentPrefix = "--" ),
                    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
            ),
            @Sql(
                    value = "classpath:db/person-clean.sql",
                    config = @SqlConfig( encoding = "utf-8", separator = ";", commentPrefix = "--" ),
                    executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
            )
    } )
    public void createPersonTest(){
        List<Person> personList = personService.getAllPerson();
        Person person = new Person();
        person.setFirstName("JohnSQL");
        person.setLastName("MayerSQL");
        personService.create( person );
        personList = personService.getAllPerson();
        logger.info( "\n\n ----Running createPersonSecondOptionTest ---- \n\n\n" );
    }

    @Test
    @DisplayName( "Person creation Test Objects" )
    public void createPersonObjectsTest(){
        List<Person> personList = personService.getAllPerson();
        Person person = new Person();
        person.setFirstName("JohnCreation");
        person.setLastName("MayerCreation");
        personService.create( person );
        personList = personService.getAllPerson();
        logger.info( "\n\n ----Running createPersonObjectsTest ---- \n\n\n" );
    }

    @Test
    @DisplayName( "Person creation Test Objects" )
    public void findByFirstNameTest(){
        List<Person> persons = personService.findByFirstName( "John" );
        logger.info( "\n\n ----Running findByFirstNameTest ---- \n\n\n" );
    }

    @Test
    @DisplayName( "Person creation Test Objects" )
    public void findByFirstNameAndLastNameTest(){
        Person person = personService.findByFirstNameAndLastName( "John", "Butler" );
        logger.info( "\n\n ----Running findByFirstNameTest ---- \n\n\n" );
    }

    @Test
    @DisplayName( "Transactional - Operations - 1" )
    public void transactionalOperations1Test(){
        List<Person> personList = personService.getAllPerson();
        try
        {
            personService.transactionalOperations1();
        } catch (Exception e){

        }
        personList = personService.getAllPerson();
        logger.info( "\n\n ----Transactional - Operations - 1 ---- \n\n\n" );
    }

    @Test
    @DisplayName( "Transactional - Operations - 2" )
    public void transactionalOperations2Test(){
        List<Person> personList = personService.getAllPerson();
        personService.transactionalOperations2();
        personList = personService.getAllPerson();
        logger.info( "\n\n ----Transactional - Operations - 2 ---- \n\n\n" );
    }



}
