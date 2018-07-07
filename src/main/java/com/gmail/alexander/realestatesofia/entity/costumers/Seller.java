package com.gmail.alexander.realestatesofia.entity.costumers;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.abstracts.Property;

import javax.persistence.*;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Seller extends Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @ManyToOne
   @JoinColumn(name="real_estate_for_sale_id")
    private Property realEstatesForSale;
    public Seller(Long id, String name, String phone, Class type, Property realEstatesForSale) {
        super(id, name, phone, type);
            this.realEstatesForSale=realEstatesForSale;
    }

    public Seller() {
        super();
    }


    public void setRealEstatesForSale(Property realEstatesForSale) {
        this.realEstatesForSale = realEstatesForSale;
    }
}
