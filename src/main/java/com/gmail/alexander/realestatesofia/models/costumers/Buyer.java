package com.gmail.alexander.realestatesofia.models.costumers;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.abstracts.Properties;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class Buyer extends Customer {
    @ManyToOne
    @JoinColumn(name="id",table = "Customer")
    private int customerId;
    private int budget;

    @Transient
    private List<Properties> viewedProperties;

    public Buyer(Long id, String name, String phone, Class type, int budget, List<Properties> viewedProperties) {
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

    public List<Properties> getViewedProperties() {
        return viewedProperties;
    }

    public void setViewedProperties(List<Properties> viewedProperties) {
        this.viewedProperties = viewedProperties;
    }
}
