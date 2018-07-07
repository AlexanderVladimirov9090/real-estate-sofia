package com.gmail.alexander.realestatesofia.entity.costumers;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.concrete.ViewedRealEstate;

import javax.persistence.*;
import java.util.List;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Buyer extends Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int budget;

    @Transient
    private List<ViewedRealEstate> viewedProperties;

    public Buyer(Long id, String name, String phone, Class type, int budget, List<ViewedRealEstate> viewedProperties) {
        super(id, name, phone, type);
        this.budget = budget;
        this.viewedProperties = viewedProperties;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<ViewedRealEstate> getViewedProperties() {
        return viewedProperties;
    }

    public void setViewedProperties(List<ViewedRealEstate> viewedProperties) {
        this.viewedProperties = viewedProperties;
    }
}
