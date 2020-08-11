package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long employeeId;
    private String firstName;
    private String description;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy="employee",
            orphanRemoval = true)
    private Set<Phone> phones;

    public Employee(){

    }

    public Employee(String firstName, String description){
        this.description = description;
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(description, employee.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName,  phones, description);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
