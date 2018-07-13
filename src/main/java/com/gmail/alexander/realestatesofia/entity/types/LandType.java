package com.gmail.alexander.realestatesofia.entity.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This is the class that indicates the Land type.
 */
public class LandType {
    public static final Map<String, String> type;
    static
    {
        type = new HashMap<String, String>();
        type.put("FIELD", "Field");
        type.put("LAWN", "Lawn");
        type.put("FOREST", "Forest");
    }
}
