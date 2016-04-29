package com.example.guest.recipefinder;

import android.support.test.rule.ActivityTestRule;

import com.example.guest.recipefinder.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.ingredient1EditText)).perform(typeText("lettuce")).check(matches(withText("lettuce")));
    }

    @Test
    public void ingredientsAreSentToRecipesActivity() {
        String ingredient1 = "lettuce";
        String ingredient2 = "broccoli";
        onView(withId(R.id.ingredient1EditText)).perform(typeText(ingredient1), closeSoftKeyboard());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.ingredient2EditText)).perform(typeText(ingredient2), closeSoftKeyboard());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.findRecipesButton)).perform(click());
        onView(withId(R.id.searchTextView)).check(matches(withText("With " + ingredient1 + " and " + ingredient2 + " you can make:")));
    }
}
