package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long phoneId;

    private String phoneNumber;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return phoneId.equals(phone.phoneId) &&
                Objects.equals(phoneNumber, phone.phoneNumber) &&
                Objects.equals(employee, phone.employee) &&
                Objects.equals(description, phone.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneId, phoneNumber, employee, description);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
