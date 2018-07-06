package com.gmail.alexander.realestatesofia.models.concrete;

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
    //This annotation tells when write to database generate next id.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String contactByPhone;
    //This is how tell to the framework that this is not a Column of table.
    @Transient
    private List<RealEstateEmployee> employees;

    public Agency(Long id, String name, String address, String contactByPhone, List<RealEstateEmployee> employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactByPhone = contactByPhone;
        //    this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<RealEstateEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<RealEstateEmployee> employees) {
        this.employees = employees;
    }
}
