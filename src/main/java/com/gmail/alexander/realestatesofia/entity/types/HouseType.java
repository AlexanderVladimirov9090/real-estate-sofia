package com.gmail.alexander.realestatesofia.entity.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *  This class is used to indicate the Type of house.
 */
public class HouseType {
    public static final Map<String, String> houseType;
    static
    {
        houseType = new HashMap<String, String>();
        houseType.put("FLOOR_OF_HOUSE", "Floor Of House");
        houseType.put("HOUSE", "House");}

}
