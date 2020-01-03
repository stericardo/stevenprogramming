package com.stevenprogramming.liquibase;

import com.stevenprogramming.liquibase.config.ConfigurationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@RunWith( SpringRunner.class)
@ContextConfiguration(
        classes = {ConfigurationTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestWithLiquibase {

    @Test
    public void contextLoads() {
    }

}
