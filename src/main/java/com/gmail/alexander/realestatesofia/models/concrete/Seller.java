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
public class Seller extends Customer {
   private List<RealEstate> realEstatesForSale;
    public Seller(Long id,String name, String phone,Class type, List<RealEstate>realEstatesForSale) {
        super(id,name, phone,type);
        this.realEstatesForSale=realEstatesForSale;
    }

    public List<RealEstate> getRealEstatesForSale() {
        return realEstatesForSale;
    }

    public void setRealEstatesForSale(List<RealEstate> realEstatesForSale) {
        this.realEstatesForSale = realEstatesForSale;
    }
}
