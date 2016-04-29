package com.example.guest.recipefinder.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Guest on 4/28/16.
 */
@Parcel
public class Recipe {
    private String mName;
    private String mImageUrl;
    private String mSourceUrl;
    private String mRecipeId;
    private ArrayList<String> mIngredients;

    public Recipe() {};

    public Recipe(String name, String imageUrl, String sourceUrl, String recipeId) {
        this.mName = name;
        this.mImageUrl = imageUrl;
        this.mSourceUrl = sourceUrl;
        this.mRecipeId = recipeId;
    }

    public String getName() {
        return mName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getSourceUrl() {
        return mSourceUrl;
    }

    public String getRecipeId() {
        return mRecipeId;
    }

    public ArrayList<String> getIngredients() {
        return mIngredients;
    }
}
