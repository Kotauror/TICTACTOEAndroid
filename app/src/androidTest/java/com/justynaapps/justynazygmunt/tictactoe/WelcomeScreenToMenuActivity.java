package com.justynaapps.justynazygmunt.tictactoe;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class WelcomeScreenToMenuActivity {

    @Rule
    public IntentsTestRule<WelcomeActivity> welcomeActivityTestRule =
            new IntentsTestRule<>(WelcomeActivity.class);

    @Test
    public void clickOnButtonSendsToMenuActivity() {
        onView(withId(R.id.enterTTTButton)).perform(click());

        intended(hasComponent(MenuActivity.class.getName()));
    }
}
