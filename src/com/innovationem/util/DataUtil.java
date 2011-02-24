package com.innovationem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: murali
 * Date: Jul 25, 2010
 * Time: 2:33:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataUtil {
    public static List<String> RELATIONS = new ArrayList<String>();

    static {
        RELATIONS.add("Self");
        RELATIONS.add("Spouse");
        RELATIONS.add("Father");
        RELATIONS.add("Mother");
        RELATIONS.add("Daughter");
        RELATIONS.add("Son");
        RELATIONS.add("Brother");
        RELATIONS.add("Sister");
        RELATIONS.add("Nephew");
        RELATIONS.add("Niece");
        RELATIONS.add("Other Relatives");
        RELATIONS.add("Friend");
    }

    public static final Map<String, String> RESOLUTION_MAP = new HashMap<String, String>();
    public static final String THUMBNAIL = "0";
    public static final String MEDIUM = "1";
    public static final String LARGE = "2";

    static {
        RESOLUTION_MAP.put(THUMBNAIL, "160");
        RESOLUTION_MAP.put(MEDIUM, "900");
        RESOLUTION_MAP.put(LARGE, "1600");
    }

    public static List<String> COUNTRIES = new ArrayList<String>();

    static {
        COUNTRIES.add("United States");
        COUNTRIES.add("United Kingdom");
        COUNTRIES.add("Canada");
        COUNTRIES.add("India");
        COUNTRIES.add("Others");
    }

    public static List<String> FAVORITES = new ArrayList<String>();

    static {
        FAVORITES.add("Color");
        FAVORITES.add("Food");
        FAVORITES.add("TV Show");
        FAVORITES.add("Movie");
        FAVORITES.add("Toy");
        FAVORITES.add("Song");
        FAVORITES.add("Place");
        FAVORITES.add("Best Friend");
        FAVORITES.add("Game");
        FAVORITES.add("Sport");
    }
}
