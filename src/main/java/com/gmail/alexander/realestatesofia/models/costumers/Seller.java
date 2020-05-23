package com.gmail.alexander.realestatesofia.models.costumers;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.concrete.Employee;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This class is used for Seller information that will be stored to the database.
 * Framework will make relation to Customer table.
 */
// Framework Make Table
@Entity
public class Seller extends Customer {
    //Relations to employee table.
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /**
     * Default constructor.
     */
    public Seller() {
        super();
    }

    public Seller(int id, String name, String phone, Employee employee) {
        super(id, name, phone);

        this.employee = employee;
    }
//Setter and getters of Seller.
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
