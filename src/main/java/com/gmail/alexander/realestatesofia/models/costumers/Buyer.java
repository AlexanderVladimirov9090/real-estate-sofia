package com.gmail.alexander.realestatesofia.models.costumers;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.concrete.Employee;
import com.gmail.alexander.realestatesofia.models.concrete.ViewedRealEstate;

import javax.persistence.*;
import java.util.List;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This class is used for Buyers information that will be stored to the database.
 *     Framework will make relation to Customer table.
 */
//This will tell the framework, that this will be used as a table in the database..
@Entity
public class Buyer extends Customer {
    //NOTE This extends Customer class and will not need to have id. It will use Customer`s ID.

    private Double budget;
    //This is where the relation of employee is defined.
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee = new Employee();
    //This tells to the framework, that this is not a column.
    @Transient
    private List<ViewedRealEstate> viewedProperties;

    /**
     * Default constructor.
     */
    public Buyer() {

    }

    public Buyer(int id, String name, String phone, Double budget, Employee employee, Employee employee1, List<ViewedRealEstate> viewedProperties) {
        super(id, name, phone);
        this.budget = budget;
        this.employee = employee;
        this.viewedProperties = viewedProperties;
    }
// This are the setters and getters of the Seller.
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
