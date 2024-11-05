package com.ni.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        //DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
        //Neo4jDataAutoConfiguration.class,
        //Neo4jRepositoriesAutoConfiguration.class,
        //WebClientAutoConfiguration.class,
        //MongoAutoConfiguration.class,
        //MongoDataAutoConfiguration.class
})
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
