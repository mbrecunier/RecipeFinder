package com.example.guest.recipefinder.services;

import android.util.Log;

import com.example.guest.recipefinder.Constants;
import com.example.guest.recipefinder.models.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 4/28/16.
 */
public class FoodService {
    public static final String TAG = FoodService.class.getSimpleName();

    public static void findRecipes(String ingredient1, String ingredient2, Callback callback) {
        String API_KEY = Constants.API_KEY;
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        String ingredients = (ingredient1 + "," + ingredient2).replaceAll("\\s","");
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.KEY_QUERY_PARAMETER, API_KEY);
        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETER, ingredients);
        String url = urlBuilder.build().toString();
        Log.v(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void getRecipeIngredients(String recipeId, Callback callback) {
        String API_KEY = Constants.API_KEY;
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RECIPE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.KEY_QUERY_PARAMETER, API_KEY);
        urlBuilder.addQueryParameter(Constants.RECIPE_QUERY_PARAMETER, recipeId);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<String> processIngredientResults(Response response) {
        ArrayList<String> ingredients = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject recipeJSON = new JSONObject(jsonData);
                JSONArray ingredientsJSON = recipeJSON.getJSONArray("ingredients");
                for (int i = 0; i < ingredientsJSON.length(); i++) {
                    String ingredient = ingredientsJSON.getString(i);
                    ingredients.add(ingredient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    public ArrayList<Recipe> processResults(Response response) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject foodJSON = new JSONObject(jsonData);
                JSONArray recipesJSON = foodJSON.getJSONArray("recipes");
                for (int i = 0; i < 15; i++) {
                    JSONObject recipeJSON = recipesJSON.getJSONObject(i);
                    String name = recipeJSON.getString("title");
                    String imageUrl = recipeJSON.getString("image_url");
                    String sourceUrl = recipeJSON.getString("source_url");
                    String recipeId = recipeJSON.getString("recipe_id");
                    Log.v(TAG, recipeId);

                    Recipe recipe = new Recipe (name, imageUrl, sourceUrl, recipeId);
                    recipes.add(recipe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipes;
    }
}
