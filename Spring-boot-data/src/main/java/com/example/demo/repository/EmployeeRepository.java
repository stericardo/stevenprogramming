package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>,
        JpaSpecificationExecutor<Employee> {

}