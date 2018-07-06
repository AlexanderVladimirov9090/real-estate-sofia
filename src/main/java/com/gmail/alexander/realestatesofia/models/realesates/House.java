package com.gmail.alexander.realestatesofia.models.realesates;

import com.gmail.alexander.realestatesofia.models.abstracts.Properties;
import com.gmail.alexander.realestatesofia.models.concrete.RealEstateEmployee;
import com.gmail.alexander.realestatesofia.models.types.BuildMaterial;
import com.gmail.alexander.realestatesofia.models.types.HouseType;
import com.gmail.alexander.realestatesofia.models.types.RealEstateType;

import javax.persistence.Entity;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class House extends Properties {
    private BuildMaterial buildMaterial;
    private HouseType houseType;
    private int parkingSpace;
    private int yardSize;

    public House(Long id, Integer sizeOfRealEstate, String description, String address, Integer price, RealEstateType type, RealEstateEmployee realEstateEmployee, BuildMaterial buildMaterial, HouseType houseType, int parkingSpace, int yardSize) {
        super(id, sizeOfRealEstate, description, address, price, type, realEstateEmployee);
        this.buildMaterial = buildMaterial;
        this.houseType = houseType;
        this.parkingSpace = parkingSpace;
        this.yardSize = yardSize;
        }

    public BuildMaterial getBuildMaterial() {
        return buildMaterial;
    }

    public void setBuildMaterial(BuildMaterial buildMaterial) {
        this.buildMaterial = buildMaterial;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
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
