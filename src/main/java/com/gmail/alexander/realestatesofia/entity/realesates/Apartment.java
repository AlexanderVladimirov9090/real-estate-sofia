package com.gmail.alexander.realestatesofia.entity.realesates;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;

import javax.persistence.Entity;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Apartment extends Property {
    private String buildMaterial;
    private String apartmentType;

    public Apartment(int id, Integer sizeOfRealEstate, String description, String address, Double price, String type, Employee employee, String buildMaterial, String apartmentType) {
        super(id, sizeOfRealEstate, description, address, price, type, employee);
        this.buildMaterial = buildMaterial;
        this.apartmentType = apartmentType;
    }

    public Apartment() {
        super();
    }

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
