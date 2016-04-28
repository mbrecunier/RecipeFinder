package com.example.guest.recipefinder;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 4/28/16.
 */
public class FoodService {

    public static void findRecipes(String ingredient1, String ingredient2, Callback callback) {
        String API_KEY = Constants.API_KEY;
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.KEY_QUERY_PARAMETER, API_KEY);
        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETER, ingredient1);
        urlBuilder.addQueryParameter(Constants.SECOND_QUERY_PARAMETER, ingredient2);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
