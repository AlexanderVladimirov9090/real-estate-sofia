package com.gmail.alexander.realestatesofia.models.abstracts;

import com.gmail.alexander.realestatesofia.models.concrete.RealEstateEmployee;
import com.gmail.alexander.realestatesofia.models.types.BuildMaterial;
import com.gmail.alexander.realestatesofia.models.types.RealEstateType;

import javax.persistence.*;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the Properties class that is going to be a representative from the database.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer sizeOfRealEstate;
    private String description;
    private String address;
    private Integer price;
    private RealEstateType realEstateType;
    /*


    /*@ManyToOne
    @JoinColumn(name = "id")
    */
    @Transient
    private RealEstateEmployee realEstateEmployee;

    public Properties(Long id, Integer sizeOfRealEstate, String description, String address, Integer price, RealEstateType realEstateType, RealEstateEmployee realEstateEmployee) {
        this.id = id;
        this.sizeOfRealEstate = sizeOfRealEstate;
        this.description = description;
        this.address = address;
        this.price = price;
        this.realEstateType = realEstateType;
        this.realEstateEmployee = realEstateEmployee;
    }


}
