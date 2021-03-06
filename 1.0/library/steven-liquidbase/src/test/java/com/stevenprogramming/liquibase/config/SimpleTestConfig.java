package com.stevenprogramming.liquibase.config;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@SpringBootConfiguration
@ComponentScan( basePackages = { "com.stevenprogramming.liquibase" },
excludeFilters = { @ComponentScan.Filter ( type = FilterType.ASSIGNABLE_TYPE, value = DBInitializer.class ) } )
@Profile( "test" )
@EnableTransactionManagement
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SimpleTestConfig
{

    private static Logger logger = LoggerFactory.getLogger( SimpleTestConfig.class );

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setShouldRun(false);
        return liquibase;
    }

    @Bean
    public DataSource dataSource ( ){
        try{
            EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder(  );
            return databaseBuilder.setType( EmbeddedDatabaseType.H2 ).build();
        } catch (Exception e){
            logger.error( "Embedded Database error ", e );
            return null;
        }
    }

    @Bean
    PropertyPlaceholderConfigurer propConfig() {
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("test.properties"));
        return placeholderConfigurer;
    }

    @Bean
    EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("test-unit");
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }


}
