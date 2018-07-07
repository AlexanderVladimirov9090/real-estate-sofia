package com.gmail.alexander.realestatesofia.entity.realesates;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.RealEstateEmployee;
import com.gmail.alexander.realestatesofia.entity.types.AparmentType;
import com.gmail.alexander.realestatesofia.entity.types.BuildMaterial;
import com.gmail.alexander.realestatesofia.entity.types.RealEstateType;

import javax.persistence.Entity;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Apartment extends Property {
    private BuildMaterial buildMaterial;
    private AparmentType aparmentType;

    public Apartment(Long id, Integer sizeOfRealEstate, String description, String address, Integer price, RealEstateType type, RealEstateEmployee realEstateEmployee, BuildMaterial buildMaterial, AparmentType aparmentType) {
        super(id, sizeOfRealEstate, description, address, price, type, realEstateEmployee);
        this.buildMaterial = buildMaterial;
        this.aparmentType = aparmentType;
    }

    public BuildMaterial getBuildMaterial() {
        return buildMaterial;
    }

    public void setBuildMaterial(BuildMaterial buildMaterial) {
        this.buildMaterial = buildMaterial;
    }

    public AparmentType getAparmentType() {
        return aparmentType;
    }

    public void setAparmentType(AparmentType aparmentType) {
        this.aparmentType = aparmentType;
    }
}
