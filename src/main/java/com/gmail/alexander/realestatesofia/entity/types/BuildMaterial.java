package com.gmail.alexander.realestatesofia.entity.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the realEstateType of build material that is used to construct the establishment.
 */
public class BuildMaterial {
    public static final Map<String, String> type;
    static
    {
        type = new HashMap<String, String>();
        type.put("EPK", "EPK");
        type.put("BRICK", "Brick");
        type.put("PANEL", "Panel");
        type.put("MUDBRICK", "Mudbrick");
    }
}
