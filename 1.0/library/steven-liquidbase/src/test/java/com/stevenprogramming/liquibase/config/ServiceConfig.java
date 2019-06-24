package com.stevenprogramming.liquibase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@SpringBootConfiguration
@EnableJpaRepositories(basePackages = {"com.stevenprogramming.liquibase.repositories"})
@ComponentScan(basePackages = {"com.stevenprogramming.liquibase"})
public class ServiceConfig
{
    @Autowired
    DataSource dataSource;

    @Bean
    public Properties hibernateProperties(){
        Properties hibernateProperties = new Properties(  );
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect" );
        hibernateProperties.put("hibernate.hbm2ddl.auto","create-drop" );
        hibernateProperties.put("hibernate.show_sql",true );
        hibernateProperties.put("hibernate_max_fetch_depth", 3 );
        hibernateProperties.put("hibernate.jdbc.batch_size", 10 );
        hibernateProperties.put("hibernate.jdbc.fetch_size", 50 );
        return hibernateProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager( entityManagerFactory() );
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter( ) {
        return new HibernateJpaVendorAdapter( );
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean( );
        factoryBean.setPackagesToScan( "com.stevenprogramming.liquibase.model" );
        factoryBean.setDataSource( dataSource );
        factoryBean.setJpaVendorAdapter( jpaVendorAdapter( ) );
        factoryBean.setJpaProperties( hibernateProperties( ) );
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory( );
    }

}
