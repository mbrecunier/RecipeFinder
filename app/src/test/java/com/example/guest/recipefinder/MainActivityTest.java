package com.example.guest.recipefinder;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import com.example.guest.recipefinder.ui.MainActivity;
import com.example.guest.recipefinder.ui.RecipesActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView introTextView = (TextView) activity.findViewById(R.id.introTextView);
        assertTrue(("Find recipes using what you have in your kitchen").equals(introTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted() {
        activity.findViewById(R.id.findRecipesButton).performClick();
        Intent expectedIntent = new Intent(activity, RecipesActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
