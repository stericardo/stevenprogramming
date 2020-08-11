package com.example.demo;

import de.flapdoodle.embed.process.runtime.Network;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;
import ru.yandex.qatools.embed.postgresql.PostgresExecutable;
import ru.yandex.qatools.embed.postgresql.PostgresProcess;
import ru.yandex.qatools.embed.postgresql.PostgresStarter;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static java.lang.String.format;
import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;
import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V9_6;

@Configuration
@EnableTransactionManagement
//@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example" )
public class DBConfig {

    private static final List<String> DEFAULT_ADDITIONAL_INIT_DB_PARAMS = Arrays
            .asList("--nosync", "--locale=en_US.UTF-8");

/*
        @Bean
        @ConfigurationProperties("spring.datasource")
        @Primary
        public DataSource dataSource() throws Exception {
            final EmbeddedPostgres postgres = new EmbeddedPostgres(V9_6);
            final String url = postgres.start("localhost", 5432,
                    "dbName", "userName", "password");
            final Connection conn = DriverManager.getConnection(url);
            conn.createStatement().execute("CREATE TABLE films (code char(5));");
            conn.createStatement().execute("INSERT INTO films VALUES ('movie');");


            return DataSourceBuilder
                    .create()
                    .build();
        }*/

    @Bean
    @DependsOn("postgresProcess")
    public DataSource dataSource(PostgresConfig config) {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(format("jdbc:postgresql://%s:%s/%s", config.net().host(),
                config.net().port(), config.storage().dbName()));
        ds.setUsername(config.credentials().username());
        ds.setPassword(config.credentials().password());
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean lcemfb
                = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        // set the packages to scan , it can be useful if you have big project and you just need to local partial entities for testing
        lcemfb.setPackagesToScan("com.example");
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(va);
        lcemfb.setJpaProperties(getHibernateProperties());
        lcemfb.afterPropertiesSet();
        return lcemfb;

    }

    @Bean
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties getHibernateProperties() {
        Properties ps = new Properties();
        ps.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        ps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        ps.put("hibernate.hbm2ddl.auto", "update");
        ps.put("hibernate.connection.characterEncoding", "UTF-8");
        ps.put("hibernate.connection.charSet", "UTF-8");

        ps.put(AvailableSettings.FORMAT_SQL, "true");
        ps.put(AvailableSettings.SHOW_SQL, "true");
        return ps;
    }

    @Bean
    public PostgresConfig postgresConfig() throws IOException {
        // make it readable from configuration source file or system , it is hard coded here for explanation purpose only
        final PostgresConfig postgresConfig = new PostgresConfig(Version.V9_6_11,
                new AbstractPostgresConfig.Net("localhost", Network.getFreeServerPort()),
                new AbstractPostgresConfig.Storage("test"),
                new AbstractPostgresConfig.Timeout(),
                new AbstractPostgresConfig.Credentials("user", "pass")
        );
        postgresConfig.getAdditionalInitDbParams().addAll(DEFAULT_ADDITIONAL_INIT_DB_PARAMS);
        return postgresConfig;
    }

    @Bean(destroyMethod = "stop")
    public PostgresProcess postgresProcess(PostgresConfig config) throws IOException {
        PostgresStarter<PostgresExecutable, PostgresProcess> runtime = PostgresStarter.getDefaultInstance();
        PostgresExecutable exec = runtime.prepare(config);
        PostgresProcess process = exec.start();
        return process;
    }
}
