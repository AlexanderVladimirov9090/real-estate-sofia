package com.gmail.alexander.realestatesofia.models.concrete;

import javax.persistence.*;


/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This classs correspondence to Database table of Agency.
 */

//Entity is used to show the framework that this is going to be used for the creation of table Property.
@Entity
public class Agency {
    @Id
    //There is some bug that forced it to used the name. Don`t know why.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    //This annotation is used to indicate that the field id will be the table Primary key.
    //Columns of the Table.
    private String name;
    private String address;
    private String phone;

    /**
     * Default constructor
     */
    public Agency() {
    }

    public Agency(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
/*
* Getters and Setters of Agence.
* */
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
