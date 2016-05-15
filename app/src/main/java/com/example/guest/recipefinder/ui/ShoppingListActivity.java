package com.example.guest.recipefinder.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.guest.recipefinder.R;

public class ShoppingListActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
    }

//    ArrayAdapter ingredientAdapter = new ArrayAdapter(ShoppingListActivity.this, android.R.layout.simple_list_item_1, savedIngredients);
}
