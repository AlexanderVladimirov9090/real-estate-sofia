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
    public static final Map<String, String> landType;
    static
    {
        landType = new HashMap<String, String>();
        landType.put("FIELD", "Field");
        landType.put("LAWN", "Lawn");
        landType.put("FOREST", "Forest");
    }
}
