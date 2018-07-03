package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(AndroidJUnit4.class)
public class WelcomeScreenUI {

    @Rule
    public ActivityTestRule<WelcomeActivity> mActivityRule =
            new ActivityTestRule(WelcomeActivity.class);

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.justynaapps.justynazygmunt.tictactoe", appContext.getPackageName());
    }

    @Test
    public void hasClickButtonMessage() {
        onView(withText("Click the button below to enter the game!")).check(matches(isDisplayed()));
    }
}