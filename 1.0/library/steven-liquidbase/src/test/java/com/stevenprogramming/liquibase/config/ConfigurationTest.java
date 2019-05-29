package com.stevenprogramming.liquibase.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.stevenprogramming.liquibase")
@PropertySource("liquibase/liquibase-test.properties")
@EnableTransactionManagement
public class ConfigurationTest {

    @Autowired
    private Environment env;
/*
    @Bean("h2DataSource")
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.HSQL)
                .addScripts("database/script.sql")
                .build();
    }
*/
}
