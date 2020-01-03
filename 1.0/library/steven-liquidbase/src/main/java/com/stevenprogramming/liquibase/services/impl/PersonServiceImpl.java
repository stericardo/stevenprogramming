package com.stevenprogramming.liquibase.services.impl;

import com.stevenprogramming.liquibase.model.Person;
import com.stevenprogramming.liquibase.repositories.PersonRepository;
import com.stevenprogramming.liquibase.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
@Service("personService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
        return personRepository.findByFirstName( firstName );
    }

    @Override
    public Person findByFirstNameAndLastName(String firstName, String lastName){
        return personRepository.findByFirstNameAndLastName( firstName, lastName );
    }

    @Override
    public List<Person> getAllPerson(){
        return getAll( personRepository );
    }

    @Override
    public void transactionalOperations1()throws Exception{
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Operations1");
        create( person );
        person = new Person();
        person.setFirstName("John");
        person.setLastName("Operations1-1");
        create( person );
        int data = 3;
        if( data < 4 )
            throw new Exception( "transactionalOperations1" );
    }

    @Override
    public void transactionalOperations2(){
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Operations1");
        create( person );
        person = new Person();
        person.setFirstName("John");
        person.setLastName("Operations1-1");
        create( person );
    }



}
