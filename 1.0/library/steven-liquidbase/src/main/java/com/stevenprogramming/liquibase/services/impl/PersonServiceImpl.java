package com.stevenprogramming.liquibase.services.impl;

import com.stevenprogramming.liquibase.model.Person;
import com.stevenprogramming.liquibase.services.PersonService;

import java.util.List;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
public class PersonServiceImpl extends CrudServiceImpl<Person, Long> implements PersonService
{

    @Override
    public List<Person> findByFirstName(String firstName){
        return null;
    }

    @Override
    public Person findByFirstNameAndLastName(String firstName, String lastName){
        return null;
    }

}
