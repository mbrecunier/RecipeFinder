package com.example.guest.recipefinder.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.recipefinder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.findRecipesButton) Button mFindRecipesButton;
    @Bind(R.id.ingredient1EditText) EditText mIngredient1EditText;
    @Bind(R.id.ingredient2EditText) EditText mIngredient2EditText;

    //give option to filter vegan/vegetarian etc
    //give option to add more than two ingredients- recipes using most ingredients are returned first

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindRecipesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.findRecipesButton:
                String ingredient1 = mIngredient1EditText.getText().toString();
                String ingredient2 = mIngredient2EditText.getText().toString();
                Intent recipesIntent = new Intent(MainActivity.this, RecipesActivity.class);
                recipesIntent.putExtra("ingredient1", ingredient1);
                recipesIntent.putExtra("ingredient2", ingredient2);
                startActivity(recipesIntent);
                break;
            default:
                break;
        }
    }
}
