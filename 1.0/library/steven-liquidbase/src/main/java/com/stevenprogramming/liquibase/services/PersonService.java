package com.stevenprogramming.liquibase.services;

import com.stevenprogramming.liquibase.model.Person;

import java.util.List;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
public interface PersonService extends CrudService<Person, Long>
{

    List<Person> findByFirstName(String firstName);

    Person findByFirstNameAndLastName(String firstName, String lastName);

    List<Person> getAllPerson();

    void transactionalOperations1() throws Exception;

    void transactionalOperations2();

}

