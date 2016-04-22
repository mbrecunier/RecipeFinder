package com.example.guest.recipefinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity {
    @Bind(R.id.searchTextView) TextView mSearchTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        Intent recipesIntent = getIntent();
        String ingredient1 = recipesIntent.getStringExtra("ingredient1");
        String ingredient2 = recipesIntent.getStringExtra("ingredient2");
        mSearchTextView.setText("With " + ingredient1 + " and " + ingredient2 + " you can make:");
    }
}
