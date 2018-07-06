package com.gmail.alexander.realestatesofia.models.costumers;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.abstracts.Properties;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Seller extends Customer {
    @Transient
    private Properties realEstatesForSale;
    public Seller(Long id, String name, String phone, Class type, Properties realEstatesForSale) {
        super(id, name, phone, type);
        //     this.realEstatesForSale=realEstatesForSale;
    }


   /* public void setRealEstatesForSale(Properties realEstatesForSale) {
        this.realEstatesForSale = realEstatesForSale;
    }*/
}
