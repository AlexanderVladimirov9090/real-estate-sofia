package com.gmail.alexander.realestatesofia.entity.abstracts;

import com.gmail.alexander.realestatesofia.entity.concrete.Employee;

import javax.persistence.*;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the abstract class of Customer that is extendet by Buyer and Seller conreate classes.
 */
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String phone;
    @ManyToOne
    @JoinColumn(name="REAL_ESTATE_EMPLOYEE_ID")
    private Employee employee;

    public Customer() {
    }

    public Customer(int id, String name, String phone,Employee employee) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.employee=employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
