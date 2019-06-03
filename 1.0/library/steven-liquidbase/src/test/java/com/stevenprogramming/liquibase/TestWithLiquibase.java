package com.stevenprogramming.liquibase;

import com.stevenprogramming.liquibase.config.ConfigurationTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {ConfigurationTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestWithLiquibase {

    @Test
    public void contextLoads() {
    }

}
