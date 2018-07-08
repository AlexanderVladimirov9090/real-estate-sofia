package com.gmail.alexander.realestatesofia.entity.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class RealEstateType {
    public static final Map<String, String> realEstateType;

    static {
        realEstateType = new HashMap<String, String>();
        realEstateType.put("APARTMENT", "Apartment");
        realEstateType.put("HOUSE", "House");
        realEstateType.put("LAND", "Land");
    }
}
