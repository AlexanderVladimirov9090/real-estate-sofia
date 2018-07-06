package com.gmail.alexander.realestatesofia.models.realesates;

import com.gmail.alexander.realestatesofia.models.abstracts.Properties;
import com.gmail.alexander.realestatesofia.models.concrete.RealEstateEmployee;
import com.gmail.alexander.realestatesofia.models.types.LandType;
import com.gmail.alexander.realestatesofia.models.types.RealEstateType;

import javax.persistence.Entity;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class Land extends Properties {
    private boolean isRegulated;
    private LandType landType;

    public Land(Long id, Integer sizeOfRealEstate, String description, String address, Integer price, RealEstateType type, RealEstateEmployee realEstateEmployee, boolean isRegulated, LandType landType) {
        super(id, sizeOfRealEstate, description, address, price, type, realEstateEmployee);
        this.isRegulated = isRegulated;
        this.landType = landType;
    }

    public boolean isRegulated() {
        return isRegulated;
    }

    public void setRegulated(boolean regulated) {
        isRegulated = regulated;
    }

    public LandType getLandType() {
        return landType;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }
}
