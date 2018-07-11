package com.gmail.alexander.realestatesofia.entity.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *
 *     This is the realEstateType of houses, that could be selled from the agency.
 */
public class HouseType {
    public static final Map<String, String> houseType;
    static
    {
        houseType = new HashMap<String, String>();
        houseType.put("FLOOR_OF_HOUSE", "Floor Of House");
        houseType.put("HOUSE", "House");}

}
