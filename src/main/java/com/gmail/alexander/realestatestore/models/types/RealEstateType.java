package com.gmail.alexander.realestatestore.models.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 06.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This class is used to Indicate the Type of the Property.
 *
 */
public class RealEstateType {
    public static final Map<String, String> type;

    static {
        type = new HashMap<String, String>();
        type.put("APARTMENT", "Apartment");
        type.put("HOUSE", "House");
        type.put("LAND", "Land");
    }
}
