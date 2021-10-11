package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.filter.EmployeeFilter;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.specification.EmployeeSpecification;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createInitialData(){
        Employee employee = new Employee();
        employee.setDescription("Desc");
        employee.setFirstName("Steven");
        employee = employeeRepository.save(employee);
        lockObject(employee);
        //createInitialData2();

    }

    @Transactional(propagation = Propagation.MANDATORY)
    protected void lockObject(final Employee employee){
        Session session = sessionFactory.getCurrentSession();
        //Transaction tx = session.getTransaction();
        //tx.begin();
        session.evict(employee);
        session.buildLockRequest(new LockOptions(LockMode.NONE)).lock(employee);
        //tx.commit();
    }


    public void createInitialData2(){
        Employee employee = new Employee();
        employee.setDescription("Desc2");
        employee.setFirstName("Steven2");
        employee = employeeRepository.save(employee);
    }

    @Override
    public Set<Employee> fetchByDescription(String[] words, int type){
        EmployeeFilter employeeFilter = new EmployeeFilter();
        employeeFilter.setWords(words);
        employeeFilter.setType(type);
        EmployeeSpecification employeeSpecification = new EmployeeSpecification(employeeFilter);
        return employeeRepository.findAll(employeeSpecification).stream().collect(Collectors.toSet());
    }

    @Override
    public void populateDatabase(){
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Callable<String> callableTask = () -> {
            for(int i =600000; i < 700000; i++){
                employeeRepository.save(new Employee("Name "+ ">" + i, getDescription()));
            }
            return "Task's execution";
        };
        Callable<String> callableTask2 = () -> {
            for(int i =500000; i < 600000; i++){
                employeeRepository.save(new Employee("Name "+ ">" + i, getDescription()));
            }
            return "Task's execution";
        };
        Callable<String> callableTask3 = () -> {
            for(int i =700000; i < 800000; i++){
                employeeRepository.save(new Employee("Name "+ ">" + i, getDescription()));
            }
            return "Task's execution";
        };
        Callable<String> callableTask4 = () -> {
            for(int i =900000; i < 1000000; i++){
                employeeRepository.save(new Employee("Name "+ ">" + i, getDescription()));
            }
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask2);
        callableTasks.add(callableTask3);
        callableTasks.add(callableTask4);

        try {
            String result = executor.invokeAny(callableTasks);
        } catch (Exception e){

        }

    }

    @Override
    public void populateDatabase2(){
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Callable<String> callableTask = () -> {
            for(int i =1; i < 100; i++){
                employeeRepository.save(new Employee("Name "+ ">" + i, getDescription()));
            }
            return "Task's execution";
        };


        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);

        try {
            String result = executor.invokeAny(callableTasks);
        } catch (Exception e){

        }

    }

    public String getDescription(){
        String result = "Data test value ";
        Random rn = new Random();
        int v = rn.nextInt(20 - 1 + 1) + 1;
        switch (v){
            case 1:result += "hi 4566 there"; break;
            case 2:result += "fresh 8756657 market"; break;
            case 3:result += "guide 5665 total"; break;
            case 4:result += "to many 2323"; break;
            case 5:result += "at 45656 value"; break;
            case 6:result += "of 86565 set"; break;
            case 7:result += "map 5655 information"; break;
            case 8:result += "guys  889 please"; break;
            case 9:result += "do not 6778 get"; break;
            case 10:result += "much 234545 time"; break;
            case 11:result += "say 22435 words"; break;
            case 12:result += "timeline 454543 for me"; break;
            case 13:result += "I talk 345345"; break;
            case 14:result += "fortune 3451767 gress"; break;
            case 15:result += "let me 34544"; break;
            case 16:result += "go into 987787 situation"; break;
            case 17:result += "forecast 788543 vi"; break;
            case 18:result += "what 7557423 happen"; break;
            case 19:result += "with you and 6438"; break;
            case 20:result += "matt 23567 full"; break;
            default: result += "default 25787 more Spring"; break;
        }
        return result;
    }
}
