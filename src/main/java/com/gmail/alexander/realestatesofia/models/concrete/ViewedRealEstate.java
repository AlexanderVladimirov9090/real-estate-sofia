package com.gmail.alexander.realestatesofia.models.concrete;

import com.gmail.alexander.realestatesofia.models.abstracts.Properties;
import com.gmail.alexander.realestatesofia.models.costumers.Buyer;

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
    @Transient
    private Properties propertiesForView;
    @Transient
    private RealEstateEmployee agent;
    @Transient
    private Buyer buyers;

    private Date realEstateViewingDate;
}
