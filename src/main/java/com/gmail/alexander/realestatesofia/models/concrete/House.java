package com.gmail.alexander.realestatesofia.models.concrete;

import com.gmail.alexander.realestatesofia.models.abstracts.RealEstate;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class House extends RealEstate {
    private int parkingSpaces;
    private int sizeOfLawn;


    public House(Long id, Integer size, String description, String address, Integer price, Enum type, RealEstateAgent realEstateAgent) {
        super(id, size, description, address, price, type, realEstateAgent);
    }
}
