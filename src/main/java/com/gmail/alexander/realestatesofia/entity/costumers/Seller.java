package com.gmail.alexander.realestatesofia.entity.costumers;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Seller extends Customer {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    public Seller() {
        super();
    }

    public Seller(int id, String name, String phone, Employee employee) {
        super(id, name, phone);

        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
