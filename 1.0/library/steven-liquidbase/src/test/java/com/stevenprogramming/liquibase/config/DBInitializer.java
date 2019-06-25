package com.stevenprogramming.liquibase.config;

import com.stevenprogramming.liquibase.model.Person;
import com.stevenprogramming.liquibase.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Service
public class DBInitializer
{
    private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Mayer");
        person.setEntityCreationTimestamp( Instant.now() );
        person.setLastUpdatedTimestamp( Instant.now() );
        person.setEntityVersion( 1 );
        personRepository.save(person);

        person = new Person();
        person.setFirstName("Eric");
        person.setLastName("Clapton");
        person.setEntityCreationTimestamp( Instant.now() );
        person.setLastUpdatedTimestamp( Instant.now() );
        person.setEntityVersion( 1 );
        personRepository.save(person);

        person = new Person();
        person.setFirstName("John");
        person.setLastName("Butler");
        person.setEntityCreationTimestamp( Instant.now() );
        person.setLastUpdatedTimestamp( Instant.now() );
        person.setEntityVersion( 1 );
        personRepository.save(person);
        
        logger.info("Database initialization finished.");
    }
}
