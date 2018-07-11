package com.gmail.alexander.realestatesofia.entity.realesates;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Land extends Property {
    @Column(name = "is_regulated")
    private boolean isRegulated;
    @Column(name = "land_type")
    private String landType;

    public Land(int id, Integer sizeOfRealEstate, String description, String address, Double price, String type, Employee employee, Seller seller, boolean isRegulated, String landType, boolean isSold) {
        super(id, sizeOfRealEstate, description, address, price, type, employee, seller, isSold);
        this.isRegulated = isRegulated;
        this.landType = landType;
    }

    public Land() {

    }

    public boolean isRegulated() {
        return isRegulated;
    }

    public void setRegulated(boolean regulated) {
        isRegulated = regulated;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }
}
