package com.gmail.alexander.realestatesofia.entity.concrete;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class ViewedRealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="property_for_view")
    private Property propertyForView;
    @ManyToOne
    @JoinColumn(name="agent_id")
    private RealEstateEmployee agent;
    @ManyToOne
    @JoinColumn(name="buyers_id")
    private Buyer buyers;

    private Date realEstateViewingDate;
}
