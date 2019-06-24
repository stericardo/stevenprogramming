package com.stevenprogramming.liquibase.config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@RunWith( SpringRunner.class)
@SpringJUnitConfig( classes = { SimpleTestConfig.class, ServiceConfig.class })
@DisplayName( "ConfigurationTest" )
@ActiveProfiles("test")
public class ConfigurationTest {

    @Value("${subscriber:admin@example.com}")
    private String theSubscriber;

    private static Logger logger = LoggerFactory.getLogger( ConfigurationTest.class );

    @BeforeAll
    static void setup(){
        logger.info( "\n\n#### Running \n\n\n" );
    }

    @BeforeEach
    void init(){
        logger.info( "\n\n%%%% BeforeEach \n\n\n" );
    }

    @Test
    @DisplayName( "Context Test" )
    public void contextTest(){

        logger.info( "\n\n ----Running contextTest ---- \n\n\n" );
    }

/*
    @Autowired
    private Environment env;

    @Value("${hibernate.hbm2ddl.auto}")
    private String autoDdl;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.stevenprogramming.liquibase.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource restDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType( EmbeddedDatabaseType.HSQL)
                .build();
        return db;
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
            }
        };
    }
*/
}
