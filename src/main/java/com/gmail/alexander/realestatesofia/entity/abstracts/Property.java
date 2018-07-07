package com.gmail.alexander.realestatesofia.entity.abstracts;

import com.gmail.alexander.realestatesofia.entity.concrete.RealEstateEmployee;
import com.gmail.alexander.realestatesofia.entity.types.RealEstateType;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer sizeOfRealEstate;
    private String description;
    private String address;
    private Integer price;
    private RealEstateType realEstateType;

    @Transient
    private RealEstateEmployee realEstateEmployee;

    public Property(Long id, Integer sizeOfRealEstate, String description, String address, Integer price, RealEstateType realEstateType, RealEstateEmployee realEstateEmployee) {
        this.id = id;
        this.sizeOfRealEstate = sizeOfRealEstate;
        this.description = description;
        this.address = address;
        this.price = price;
        this.realEstateType = realEstateType;
        this.realEstateEmployee = realEstateEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }

    public RealEstateEmployee getRealEstateEmployee() {
        return realEstateEmployee;
    }

    public void setRealEstateEmployee(RealEstateEmployee realEstateEmployee) {
        this.realEstateEmployee = realEstateEmployee;
    }
}
