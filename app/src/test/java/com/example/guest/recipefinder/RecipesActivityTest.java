package com.example.guest.recipefinder;

import android.os.Build;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class RecipesActivityTest {
    private RecipesActivity activity;
    private ListView mRecipesListView;

    //getting nullpointer errors when trying to bind views with butterknife in testing files

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(RecipesActivity.class);
        mRecipesListView = (ListView) activity.findViewById(R.id.recipeListView);
    }

    @Test
    public void recipeListViewPopulates() {
        assertNotNull(mRecipesListView.getAdapter());
        assertEquals(mRecipesListView.getAdapter().getCount(), 5);
    }
}
