package com.example.guest.recipefinder;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchTextView) TextView mSearchTextView;
    @Bind(R.id.recipeListView) ListView mRecipeListView;
    private String[] recipes = new String[] {"Parmesan Roasted Potatoes", "Crash Hot Potatoes", "Mac and Cheese with Roasted Chicken, Goat Cheese, and Rosemary", "Stovetop Avocado Mac and Cheese", "Jalapeno Popper Grilled Cheese Sandwich" };

    //load in recipe information from Food2Fork api based on user search
    //create custom array adapter to display pictures

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

        ArrayAdapter recipesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes);
        mRecipeListView.setAdapter(recipesAdapter);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.findRestaurantsButton:
//                String location = mLocationEditText.getText().toString();
//                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
//                intent.putExtra("location", location);
//                startActivity(intent);
//                break;
//            default:
//                break;
//        }
    }
}
