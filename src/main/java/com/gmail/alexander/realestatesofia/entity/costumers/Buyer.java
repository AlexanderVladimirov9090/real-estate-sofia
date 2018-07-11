package com.gmail.alexander.realestatesofia.entity.costumers;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.concrete.ViewedRealEstate;

import javax.persistence.*;
import java.util.List;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Buyer extends Customer {
    private Double budget;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee = new Employee();
    @Transient
    private List<ViewedRealEstate> viewedProperties;

    public Buyer(int id, String name, String phone, Double budget, Employee employee, Employee employee1, List<ViewedRealEstate> viewedProperties) {
        super(id, name, phone);
        this.budget = budget;
        this.employee = employee;
        this.viewedProperties = viewedProperties;
    }

    public Buyer() {

    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public List<ViewedRealEstate> getViewedProperties() {
        return viewedProperties;
    }

    public void setViewedProperties(List<ViewedRealEstate> viewedProperties) {
        this.viewedProperties = viewedProperties;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
