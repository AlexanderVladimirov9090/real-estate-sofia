package com.gmail.alexander.realestatesofia.models.concrete;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.abstracts.RealEstate;

import java.util.List;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class Buyer extends Customer {
    private int budget;
    private List<RealEstate> viewedRealEstates;
    public Buyer(Long id,String name, String phone,Class type, int budget,List<RealEstate> viewedRealEstates) {
        super(id,name, phone,type);
        this.budget=budget;
        this.viewedRealEstates=viewedRealEstates;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<RealEstate> getViewedRealEstates() {
        return viewedRealEstates;
    }

    public void setViewedRealEstates(List<RealEstate> viewedRealEstates) {
        this.viewedRealEstates = viewedRealEstates;
    }
}
