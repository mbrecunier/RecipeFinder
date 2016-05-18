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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShoppingListActivity extends BaseActivity {
    @Bind(R.id.shoppingListView) ListView mShoppingListView;
    private Firebase ingredientRef;
    private Query mQuery;
    private ValueEventListener ingredientEventListener;
    private List<String> ingredientArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);
        ingredientRef = new Firebase(Constants.FIREBASE_URL_SHOPPING_LIST);

        Firebase ref = new Firebase(Constants.FIREBASE_URL);
        String uid = ref.getAuth().getUid();
        ingredientEventListener = ingredientRef.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String item = snapshot.getValue(String.class);
                    Log.d("ITEM FROM FIREBASE", item);
                    ingredientArray.add(item);
                }
                setUpListAdapter();
//                String shoppingList = dataSnapshot.getValue().toString();
//                Log.d("List updated", shoppingList);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

//        setUpFirebaseQuery();
//        setUpListAdapter();

    }

//    private void setUpFirebaseQuery() {
//        Firebase ref = new Firebase(Constants.BASE_URL);
//        String uid = ref.getAuth().getUid();
//        String shoppinglist = ingredientRef.child(uid).toString();
//        mQuery = new Firebase(shoppinglist);
//    }
//
    private void setUpListAdapter() {
        String[] ingredients = new String[ingredientArray.size()];
        ingredients = ingredientArray.toArray(ingredients);
        ArrayAdapter ingredientAdapter = new ArrayAdapter(ShoppingListActivity.this, android.R.layout.simple_list_item_1, ingredients);
        mShoppingListView.setAdapter(ingredientAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ingredientRef.removeEventListener(ingredientEventListener);
    }


}
