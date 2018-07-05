package com.gmail.alexander.realestatesofia.models.concrete;

import com.gmail.alexander.realestatesofia.models.abstracts.RealEstate;

import java.util.List;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class RealEstateAgent {
    private final Long id;
    private String name;
    private String address;
    private String phone;
    private List<Seller> sellers;
    private List<Buyer> buyers;
    private Map<RealEstate,List<Buyer>> visitedByBuyers;


    public RealEstateAgent(Long id,
                           String name,
                           String address,
                           String phone,
                           List<Seller> sellers,
                           List<Buyer> buyers,
                           Map<RealEstate, List<Buyer>> visitedByBuyers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.sellers = sellers;
        this.buyers = buyers;
        this.visitedByBuyers = visitedByBuyers;
    }
}
