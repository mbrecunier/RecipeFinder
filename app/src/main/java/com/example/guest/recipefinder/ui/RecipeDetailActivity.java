package com.example.guest.recipefinder.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.recipefinder.R;
import com.example.guest.recipefinder.adapters.RecipePagerAdapter;
import com.example.guest.recipefinder.models.Recipe;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipeDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private RecipePagerAdapter adapterViewPager;
    ArrayList<Recipe> mRecipes = new ArrayList<>();

    private String[] ingredients = new String[] {"2 jalapeno peppers, cut in half lengthwise and seeded", "2 slices sourdough bread", "1 tablespoon butter, room temperature", "2 tablespoons cream cheese, room temperature", "1/2 cup jack and cheddar cheese, shredded", "1 tablespoon tortilla chips, crumbled" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        ButterKnife.bind(this);
        mRecipes = Parcels.unwrap(getIntent().getParcelableExtra("recipes"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new RecipePagerAdapter(getSupportFragmentManager(), mRecipes);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

//        mNameTextView.setText(recipeName);
//
//        ArrayAdapter ingredientsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredients);
//        mIngredientListView.setAdapter(ingredientsAdapter);
    }
}
