package com.example.guest.recipefinder.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.recipefinder.R;
import com.example.guest.recipefinder.models.Recipe;
import com.example.guest.recipefinder.services.FoodService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RecipesActivity extends AppCompatActivity {
    public ArrayList<Recipe> mRecipes = new ArrayList<>();
    public static final String TAG = RecipesActivity.class.getSimpleName();
    private RecipeListAdapter mAdapter;
    @Bind(R.id.searchTextView) TextView mSearchTextView;
    @Bind(R.id.recipeListView) ListView mRecipeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        Resources res = getResources();
        Intent recipesIntent = getIntent();
        String ingredient1 = recipesIntent.getStringExtra("ingredient1");
        String ingredient2 = recipesIntent.getStringExtra("ingredient2");
        mSearchTextView.setText(String.format(res.getString(R.string.recipe_results), ingredient1, ingredient2));
        getRecipes(ingredient1, ingredient1);
    }

    private void getRecipes(String ingredient1, String ingredient2) {
        final FoodService foodService = new FoodService();

        foodService.findRecipes(ingredient1, ingredient2, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mRecipes = foodService.processResults(response);

                RecipesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new RecipeListAdapter(getApplicationContext(), mRecipes);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipesActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });

            }
        });
    }

}