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
    public static final Map<String, String> realEstatetype;

    static {
        realEstatetype = new HashMap<String, String>();
        realEstatetype.put("APARTMENT", "Studio");
        realEstatetype.put("HAUSE", "Garsoniera");
        realEstatetype.put("LAND", "Two_Room_Apartment");
    }
}
