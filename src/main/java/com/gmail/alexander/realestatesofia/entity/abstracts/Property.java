package com.gmail.alexander.realestatesofia.entity.abstracts;

import com.gmail.alexander.realestatesofia.entity.concrete.Employee;

import javax.persistence.*;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the Property class that is going to be a representative from the database.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Property {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private Integer sizeOfRealEstate;
    private String description;
    private String address;
    private Double price;
    private String realEstateType;

    @ManyToOne
    @JoinColumn(name= "employeeId")
    private Employee employee;

    public Property(int id, Integer sizeOfRealEstate, String description, String address, Double price, String realEstateType, Employee employee) {
        this.id = id;
        this.sizeOfRealEstate = sizeOfRealEstate;
        this.description = description;
        this.address = address;
        this.price = price;
        this.realEstateType = realEstateType;
        this.employee = employee;
    }

    public Property() {

    }

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

    public Employee getEmployee() { ;
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
