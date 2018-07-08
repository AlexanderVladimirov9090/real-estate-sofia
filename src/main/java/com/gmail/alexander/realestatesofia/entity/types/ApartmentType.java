package com.gmail.alexander.realestatesofia.entity.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This is the realEstateType of aparments, that could be selled from the agency.
 * TODO Find better word for GARSONIERA.
 */
public class ApartmentType {
    public static final Map<String, String> type;
    static
    {
        type = new HashMap<String, String>();
        type.put("STUDIO", "Studio");
        type.put("GARSONIERA", "Garsoniera");
        type.put("TWO_ROOM_APARTMENT", "Two_Room_Apartment");
        type.put("THREE_ROOM_APARTMENT", "TREE_ROOM_APARTMENT");
        type.put("MAINSONETTE", "Mainsonette");

    }
}
