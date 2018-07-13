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
 * This class is used for House information that will be stored to the database.
 * Framework will make relation to Property table when extended by this class.
 */
//Make Table.
@Entity
public class House extends Property {
    //Columns of te table. Property ID will be used to generate id.
    private String buildMaterial;
    private String houseType;
    private int parkingSpace;
    private int yardSize;

    /**
     * Default constructor.
     */
    public House() {
        super();
    }

    public House(int id, Integer sizeOfRealEstate, String description, String address, Double price, String type, Employee employee, Seller seller, String buildMaterial, String houseType, int parkingSpace, int yardSize, boolean isSold) {
        super(id, sizeOfRealEstate, description, address, price, type, employee, seller, isSold);
        this.buildMaterial = buildMaterial;
        this.houseType = houseType;
        this.parkingSpace = parkingSpace;
        this.yardSize = yardSize;
    }

    //Setters and Getters of House class.
    public String getBuildMaterial() {
        return buildMaterial;
    }

    public void setBuildMaterial(String buildMaterial) {
        this.buildMaterial = buildMaterial;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public int getYardSize() {
        return yardSize;
    }

    public void setYardSize(int yardSize) {
        this.yardSize = yardSize;
    }
}
