package com.gmail.alexander.realestatestore.models.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This class is used to indicate The Apartment`s Type.
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
