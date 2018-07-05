package com.gmail.alexander.realestatesofia.models.concrete;

import com.gmail.alexander.realestatesofia.models.abstracts.RealEstate;

import java.util.Date;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class ViewedRealEstate {
    private RealEstate realEstateForView;
    private RealEstateAgent agent;
    private Buyer buyers;
    private Date realEstateViewingDate;
}
