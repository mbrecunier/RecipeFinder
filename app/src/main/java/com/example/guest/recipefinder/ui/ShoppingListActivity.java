package com.example.guest.recipefinder.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.recipefinder.Constants;
import com.example.guest.recipefinder.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShoppingListActivity extends BaseActivity {
    @Bind(R.id.shoppingListView) ListView mShoppingListView;
    private Firebase ingredientRef;
    private Query mQuery;
    private ValueEventListener ingredientEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_shopping_list);
        ingredientRef = new Firebase(Constants.FIREBASE_URL_SHOPPING_LIST);

        ingredientEventListener = ingredientRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String shoppingList = dataSnapshot.getValue().toString();
                Log.d("List updated", shoppingList);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

//        setUpFirebaseQuery();
//        setUpListAdapter();

    }

//    private void setUpFirebaseQuery() {
//        String shoppinglist = ingredientRef.toString();
//        mQuery = new Firebase(shoppinglist);
//    }
//
//    private void setUpListAdapter() {
//        ArrayAdapter ingredientAdapter = new ArrayAdapter(ShoppingListActivity.this, android.R.layout.simple_list_item_1);
//        mShoppingListView.setAdapter(ingredientAdapter);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ingredientRef.removeEventListener(ingredientEventListener);
    }


}
