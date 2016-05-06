package com.example.guest.recipefinder.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.recipefinder.R;
import com.example.guest.recipefinder.models.Recipe;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.recipeImageView) ImageView mImageLabel;
    @Bind(R.id.recipeNameTextView) TextView mNameLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.ingredientListView) ListView mIngredientList;

    private Recipe mRecipe;

    public static RecipeDetailFragment newInstance(Recipe recipe) {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);

        ArrayAdapter ingredientAdapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, mRecipe.getIngredients());
        mIngredientList.setAdapter(ingredientAdapter);
        Picasso.with(view.getContext()).load(mRecipe.getImageUrl()).into(mImageLabel);
        mNameLabel.setText(mRecipe.getName());
        mWebsiteLabel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mRecipe.getSourceUrl()));
            startActivity(webIntent);
        }
    }

}
