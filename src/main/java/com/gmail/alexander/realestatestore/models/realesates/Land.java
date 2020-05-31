package com.gmail.alexander.realestatestore.models.realesates;

import com.gmail.alexander.realestatestore.models.abstracts.Property;
import com.gmail.alexander.realestatestore.models.concrete.Employee;
import com.gmail.alexander.realestatestore.models.costumers.Seller;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This class is used for Land information that will be stored to the database.
 * Framework will make relation to Property table when extended by this class.
 */
//Make table.
@Entity
public class Land extends Property {
    //You could set the name of the columns if needed.
    @Column(name = "is_regulated")
    private boolean isRegulated;
    @Column(name = "land_type")
    private String landType;

    /**
     * Default constructor.
     */
    public Land() {
        super();
    }

    public Land(int id, Integer sizeOfRealEstate, String description, String address, Double price, String type, Employee employee, Seller seller, boolean isRegulated, String landType, boolean isSold) {
        super(id, sizeOfRealEstate, description, address, price, type, employee, seller, isSold);
        this.isRegulated = isRegulated;
        this.landType = landType;
    }

    //Setters and Getters of the Land class.
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
