package com.gmail.alexander.realestatesofia.models.abstracts;

import com.gmail.alexander.realestatesofia.models.concrete.Employee;
import com.gmail.alexander.realestatesofia.models.costumers.Seller;

import javax.persistence.*;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This classs correspondence to Database table of Property.
 * The fields are extracted from Apartment, House and Land so the tables would not be full of null values.
 * I`m using framework for the creation of the tables and relations one another.
 */

//Entity is used to show the framework that this is going to be used for the creation of table Property.
@Entity

// This is to indicate that there will be classes that are going to be in relations with this class. This would be created in the database as PK and FK.
@Inheritance(strategy = InheritanceType.JOINED)
public class Property {

    //This annotation is used to indicate that the field id will be the table Primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //These will be the Columns of the table.
    private int id;
    private Integer sizeOfRealEstate;
    private String description;
    private String address;
    private Double price;
    private String realEstateType;
    private Boolean sold = false;

    //This is to indicate the relation between Property table and Employee table.
    @ManyToOne
    //Join Column is the FK of the Employee Table.
    @JoinColumn(name = "employeeId")
    private Employee employee = new Employee();

    //This is to indicate the relation between Property table and Seller table.
    @ManyToOne
    //Join Column is the FK of the Employee Table.
    @JoinColumn(name = "sellerId")
    private Seller seller = new Seller();

    /**
     * Default constructor
     */
    public Property() {

    }

    public Property(int id, Integer sizeOfRealEstate, String description, String address, Double price, String realEstateType, Employee employee, Seller seller, boolean sold) {
        this.id = id;
        this.sizeOfRealEstate = sizeOfRealEstate;
        this.description = description;
        this.address = address;
        this.price = price;
        this.realEstateType = realEstateType;
        this.employee = employee;
        this.seller = seller;
        this.sold = sold;
    }
/*
* These are the Getters and Setters of the Property Class.
* */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSizeOfRealEstate() {
        return sizeOfRealEstate;
    }

    public void setSizeOfRealEstate(Integer sizeOfRealEstate) {
        this.sizeOfRealEstate = sizeOfRealEstate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(String realEstateType) {
        this.realEstateType = realEstateType;
    }

    public Employee getEmployee() {
        ;
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public boolean getSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
