package com.example.guest.recipefinder.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.recipefinder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipeDetailsActivity extends AppCompatActivity {
    @Bind(R.id.ingredientListView) ListView mIngredientListView;
    @Bind(R.id.nameTextView) TextView mNameTextView;
    private String recipeName = "Jalapeno Popper Grilled Cheese Sandwich";
    private String[] ingredients = new String[] {"2 jalapeno peppers, cut in half lengthwise and seeded", "2 slices sourdough bread", "1 tablespoon butter, room temperature", "2 tablespoons cream cheese, room temperature", "1/2 cup jack and cheddar cheese, shredded", "1 tablespoon tortilla chips, crumbled" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        ButterKnife.bind(this);

        mNameTextView.setText(recipeName);

        ArrayAdapter ingredientsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredients);
        mIngredientListView.setAdapter(ingredientsAdapter);
    }
}
