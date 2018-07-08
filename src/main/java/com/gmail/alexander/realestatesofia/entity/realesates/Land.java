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
public class Land extends Property {
    private boolean isRegulated;
    private String landType;

    public Land(int id, Integer sizeOfRealEstate, String description, String address, Double price, String type, Employee employee, Seller seller, boolean isRegulated, String landType) {
        super(id, sizeOfRealEstate, description, address, price, type, employee, seller);
        this.isRegulated = isRegulated;
        this.landType = landType;
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
