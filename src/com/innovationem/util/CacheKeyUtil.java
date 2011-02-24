package com.innovationem.util;


public class CacheKeyUtil {
    static final String USER_KEY = "u";
    static final String ALBUM_KEY = "a";
    static final String ACTIvE_ALBUM_KEY = "al";
    static final String EVENT_TREE_KEY = "e";
    static final String PHOTO_SEARCH_BEAN_KEY = "ps";


    public static String albumKey(Long userID, String albumID) {
        return ALBUM_KEY + userID + albumID;
    }

    public static String userKey(Long userID) {
        return USER_KEY + userID;
    }

    public static String userEmailKey(String email) {
        return USER_KEY + email;
    }

    public static String eventTreeKey(Long userID) {
        return EVENT_TREE_KEY + userID;
    }

    public static String photoSearchBeanKey(Long userID) {
        return PHOTO_SEARCH_BEAN_KEY + userID;
    }
}
