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
 */
@Entity
public class House extends Property {
    private String buildMaterial;
    private String houseType;
    private int parkingSpace;
    private int yardSize;

    public House(int id, Integer sizeOfRealEstate, String description, String address, Double price, String type, Employee employee, Seller seller, String buildMaterial, String houseType, int parkingSpace, int yardSize) {
        super(id, sizeOfRealEstate, description, address, price, type, employee, seller);
        this.buildMaterial = buildMaterial;
        this.houseType = houseType;
        this.parkingSpace = parkingSpace;
        this.yardSize = yardSize;
        }

    public House() {

    }

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
