package com.stevenprogramming.liquibase.controllers;

import com.stevenprogramming.liquibase.model.Person;
import com.stevenprogramming.liquibase.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GreetingController
{
    @Autowired
    PersonService personService;

    @RequestMapping("/welcome")
    public ModelAndView welcome1() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
        List<Person> personList = personService.getAllPerson();
        try
        {
            personService.transactionalOperations1();
        } catch (Exception e){

        }
        personList = personService.getAllPerson();
        return new ModelAndView("welcome1", "message", message);
    }

    @RequestMapping("/welcomefine")
    public ModelAndView welcome2() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
        List<Person> personList = personService.getAllPerson();
        personService.transactionalOperations2();
        personList = personService.getAllPerson();
        return new ModelAndView("welcome2", "message", message);
    }
}
