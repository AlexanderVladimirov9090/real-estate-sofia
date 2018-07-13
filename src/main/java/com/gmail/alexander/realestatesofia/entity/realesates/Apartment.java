package com.gmail.alexander.realestatesofia.entity.realesates;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;

import javax.persistence.Entity;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This class is used for Apartment information that will be stored to the database.
 * Framework will make relation to Property table when extended by this class.
 */
//Make table
@Entity
public class Apartment extends Property {
    //NOTE ID will be used from Property class.
    //Table column.
    private String buildMaterial;
    private String apartmentType;

    /**
     * Default constructor.
     * Need to call super(), This is the Property class`s constructor.
     */
    public Apartment() {
        super();
    }

    public Apartment(int id, Integer sizeOfRealEstate, String description, String address, Double price, String type, Employee employee, Seller seller, String buildMaterial, String apartmentType, boolean isSold) {
        super(id, sizeOfRealEstate, description, address, price, type, employee, seller, isSold);
        this.buildMaterial = buildMaterial;
        this.apartmentType = apartmentType;
    }

    //Setters and Getters of the Apartment class
    public String getBuildMaterial() {
        return buildMaterial;
    }

    public void setBuildMaterial(String buildMaterial) {
        this.buildMaterial = buildMaterial;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }
}
