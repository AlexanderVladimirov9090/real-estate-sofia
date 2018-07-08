package com.gmail.alexander.realestatesofia.entity.concrete;

import javax.persistence.*;
import java.util.List;


/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the class that represents an Agency in this real estate application.
 */
//Tells to the framework: assumed that this entity and  map it to a table named Agency.
@Entity
public class Agency {
    //Using annotation to show the framework that this is the id of the object and how to be used.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String address;
    private String contactByPhone;
    //This is how tell to the framework that this is not a Column of table.
    @Transient
    private List<Employee> employees;

    public Agency() {
    }

    public Agency(int id, String name, String address, String contactByPhone, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactByPhone = contactByPhone;
        //    this.employees = employees;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactByPhone() {
        return contactByPhone;
    }

    public void setContactByPhone(String contactByPhone) {
        this.contactByPhone = contactByPhone;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}