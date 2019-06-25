package com.stevenprogramming.liquibase.services.impl;

import com.stevenprogramming.liquibase.model.Person;
import com.stevenprogramming.liquibase.repositories.PersonRepository;
import com.stevenprogramming.liquibase.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
@Service("personService")
public class PersonServiceImpl extends CrudServiceImpl<Person, Long> implements PersonService
{

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    public void initialize() {
        setCrudRepository( personRepository );
    }

    @Override
    public List<Person> findByFirstName(String firstName){
        return null;
    }

    @Override
    public Person findByFirstNameAndLastName(String firstName, String lastName){
        return null;
    }

    @Override
    public List<Person> getAllPerson(){
        return getAll( personRepository );
    }

}
