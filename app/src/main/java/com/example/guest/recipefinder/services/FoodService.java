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
        String APP_KEY = Constants.APP_KEY;
        String APP_ID = Constants.APP_ID;
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        String ingredients = (ingredient1 + "," + ingredient2).replaceAll("\\s","");
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETER, ingredients);
        urlBuilder.addQueryParameter(Constants.APP_QUERY_PARAMETER, APP_ID);
        urlBuilder.addQueryParameter(Constants.KEY_QUERY_PARAMETER, APP_KEY);
        String url = urlBuilder.build().toString();
        Log.v(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    public ArrayList<Recipe> processResults(Response response) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject returnJSON = new JSONObject(jsonData);
                JSONArray recipesJSON = returnJSON.getJSONArray("hits");
                for (int i = 0; i < 10; i++) {
                    JSONArray recipeArrayJSON = recipesJSON.getJSONArray(i);
                    Log.d(TAG, recipeArrayJSON.toString());
//                    String name = recipeJSON.getString("label");
//                    Log.d(TAG, name);
//                    String imageUrl = recipeJSON.getJSONObject("image").toString();
//                    String sourceUrl = recipeJSON.getJSONObject("url").toString();
//
//                    Recipe recipe = new Recipe (name, imageUrl, sourceUrl);
//                    recipes.add(recipe);
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
