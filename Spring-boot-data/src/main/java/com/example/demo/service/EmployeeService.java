package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {

    void populateDatabase();

    void populateDatabase2();

    Set<Employee> fetchByDescription(String[] words, int type);

}
