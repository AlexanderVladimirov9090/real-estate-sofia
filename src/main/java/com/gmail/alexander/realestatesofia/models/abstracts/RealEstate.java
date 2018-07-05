package com.gmail.alexander.realestatesofia.models.abstracts;

import com.gmail.alexander.realestatesofia.models.concrete.RealEstateAgent;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the RealEstate class that is going to be a representative from the database.
 */
public abstract class RealEstate {
    private Long id;
    private Integer size;
    private String description;
    private String address;
    private Integer price;
    private Enum type;
    private RealEstateAgent realEstateAgent;

    public RealEstate(Long id, Integer size, String description, String address, Integer price, Enum type, RealEstateAgent realEstateAgent) {
        this.id = id;
        this.size = size;
        this.description = description;
        this.address = address;
        this.price = price;
        this.type = type;
        this.realEstateAgent = realEstateAgent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public RealEstateAgent getRealEstateAgent() {
        return realEstateAgent;
    }

    public void setRealEstateAgent(RealEstateAgent realEstateAgent) {
        this.realEstateAgent = realEstateAgent;
    }
}
