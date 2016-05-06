package com.example.guest.recipefinder.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.recipefinder.R;
import com.example.guest.recipefinder.models.Recipe;
import com.example.guest.recipefinder.ui.RecipeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecipeViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.recipeImageView) ImageView mRecipeImageView;
    @Bind(R.id.recipeNameTextView) TextView mRecipeNameTextView;
    private Context mContext;
    private ArrayList<Recipe> mRecipes = new ArrayList<>();

    public RecipeViewHolder(View itemView, ArrayList<Recipe> recipes) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mRecipes = recipes;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, RecipeDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("recipes", Parcels.wrap(mRecipes));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindRecipe(Recipe recipe) {
        Picasso.with(mContext).load(recipe.getImageUrl()).into(mRecipeImageView);
        mRecipeNameTextView.setText(recipe.getName());
    }
}