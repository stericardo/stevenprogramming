package com.stevenprogramming.eclipselink.repositories;

import com.stevenprogramming.eclipselink.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
@Repository("PersonRepository")
public interface PersonRepository extends CrudRepository<Person, Long>
{

    List<Person> findByFirstName(String firstName);

    Person findByFirstNameAndLastName(String firstName, String lastName);

}
