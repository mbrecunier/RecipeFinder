package com.example.guest.recipefinder;

/**
 * Created by Guest on 4/28/16.
 */
public class Constants {
    public static final String APP_KEY = BuildConfig.APP_KEY;
    public static final String APP_ID = BuildConfig.APP_ID;

    public static final String BASE_URL = "https://api.edamam.com/search";
    public static final String QUERY_PARAMETER = "q";
    public static final String KEY_QUERY_PARAMETER = "app_key";
    public static final String APP_QUERY_PARAMETER = "app_id";

    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;
    public static final String FIREBASE_LOCATION_RECIPES = "recipes";
    public static final String FIREBASE_URL_RECIPES = FIREBASE_URL + "/" + FIREBASE_LOCATION_RECIPES;

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
}
