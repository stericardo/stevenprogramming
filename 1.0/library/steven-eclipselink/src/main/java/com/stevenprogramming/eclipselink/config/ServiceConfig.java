package com.stevenprogramming.eclipselink.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@SpringBootConfiguration
@EnableJpaRepositories(basePackages = {"com.stevenprogramming.eclipselink.repositories"})
@ComponentScan(basePackages = {"com.stevenprogramming.eclipselink"})
public class ServiceConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public Properties eclipseLinkProperties() {
        Properties eclipseLinkProperties = new Properties();
        //eclipseLinkProperties.put(PersistenceUnitProperties.WEAVING, true);
        //eclipseLinkProperties.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");

        eclipseLinkProperties.setProperty(PersistenceUnitProperties.DDL_GENERATION, "create-or-extend-tables");
        eclipseLinkProperties.setProperty(PersistenceUnitProperties.WEAVING, "static");
        eclipseLinkProperties.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, "ALL");

        // Disable caching
        eclipseLinkProperties.setProperty("eclipselink.cache.shared.default", "false");
        eclipseLinkProperties.setProperty("eclipselink.query-results-cache", "false");
        eclipseLinkProperties.setProperty("eclipselink.refresh", "true");

        return eclipseLinkProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.stevenprogramming.eclipselink.model");
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(eclipseLinkProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

}
