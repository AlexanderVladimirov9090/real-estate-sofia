package com.gmail.alexander.realestatestore.models.types;

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
    public static final Map<String, String> type;
    static
    {
        type = new HashMap<String, String>();
        type.put("FLOOR_OF_HOUSE", "Floor Of House");
        type.put("HOUSE", "House");}

}
