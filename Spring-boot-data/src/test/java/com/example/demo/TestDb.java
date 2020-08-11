package com.example.demo;


import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.IOException;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

//@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = DBConfig.class)
public class TestDb {


    //@Autowired
    //EmployeeService e;

    @BeforeAll
    public static void setUp(){

    }

    @Test
    public void testDB(){
        System.out.println("");
        //e.populateDatabase2();

        System.out.println("");
    }
}
