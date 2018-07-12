package com.gmail.alexander.realestatesofia.entity.abstracts;

import javax.persistence.*;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This classs correspondence to Database table of customer.
 * The fields are extracted from Seller and Buyer so the tables would not be full of null values.
 * I`m using framework for the creation of the tables and relations one another.
 */

//Entity is used to show the framework that this is going to be used for the creation of table Customer.
@Entity

// This is optional to show that the name of the table could be change. If not it wold be the name of the class.
@Table(name = "customer")

// This is to indicate that there will be classes that are going to be in relations with this class. This would be created in the database as Primary key and FOREIGN KEY.
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    //This annotation is used to indicate that the field id will be the table Primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //This will be the next Column of the table
    private String name;

    //This will be the next Column of the table
    private String phone;

    /**
     * This constructor is the default one.
     */
    public Customer() {
    }

    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
/*
*
* These are the Getters and Setters of the Customer class.
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
