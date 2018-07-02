package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)

public class HumanVsComputer {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.justynaapps.justynazygmunt.tictactoe", appContext.getPackageName());
    }

    @Test
    public void hasTicTacToeDisplayedOnMainScreen() {
        onView(withText("TICTACTOE")).check(matches(isDisplayed()));
    }

    @Test
    public void picksTopLeftCornerAtTheStart() {
        onView(withId(R.id.place_number_5)).perform(click());

        onView(withId(R.id.place_number_1)).check(matches(withText("O")));
    }
}
