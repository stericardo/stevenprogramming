package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/populate")
    public String greeting() {
        employeeService.populateDatabase();
        return "loading ...";
    }

    @GetMapping("/employees")
    public long getEmployees() {
        String[] words = {"fresh", "market"};
        long startTime = System.currentTimeMillis();
        Set<Employee> employeeSet = employeeService.fetchByDescription(words, 1);
        long endTime = System.currentTimeMillis();
        long timeElapsed1 = endTime - startTime;
        long size1 = employeeSet.stream().map(e -> e.getEmployeeId()).collect(Collectors.toSet()).size();

        startTime = System.currentTimeMillis();
        employeeSet = employeeService.fetchByDescription(words, 2);
        endTime = System.currentTimeMillis();
        long timeElapsed2 = endTime - startTime;

        long size2 = employeeSet.stream().map(e -> e.getEmployeeId()).collect(Collectors.toSet()).size();
        System.out.printf("%n%n%n%nTime1 %d, Size1 %d : Time2 %d, size2 %d %n%n " ,
                timeElapsed1, size1, timeElapsed2, size1);

        return size2;
    }


}
