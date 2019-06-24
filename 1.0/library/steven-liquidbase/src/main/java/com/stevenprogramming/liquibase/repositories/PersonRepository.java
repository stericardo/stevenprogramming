package com.stevenprogramming.liquibase.repositories;

import com.stevenprogramming.liquibase.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>
{

    List<Person> findByFirstName(String firstName);

    Person findByFirstNameAndLastName(String firstName, String lastName);

}
