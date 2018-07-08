package com.gmail.alexander.realestatesofia.entity.costumers;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Seller extends Customer {

    @ManyToOne
    @JoinColumn(name = "real_estate_for_sale_id")
    private Property realEstatesForSale;

    public Seller() {
        super();
    }

    public Seller(int id, String name, String phone, Property realEstatesForSale) {
        super(id, name, phone);
        this.realEstatesForSale = realEstatesForSale;
    }

    public Property getRealEstatesForSale() {
        return realEstatesForSale;
    }

    public void setRealEstatesForSale(Property realEstatesForSale) {
        this.realEstatesForSale = realEstatesForSale;
    }
}
