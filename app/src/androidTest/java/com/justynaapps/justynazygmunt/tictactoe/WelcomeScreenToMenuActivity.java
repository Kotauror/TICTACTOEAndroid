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
    public void clickOnButtonSendsToMenuActivityForHvsH() {
        onView(withId(R.id.enterTTTButton)).perform(click());
        onView(withId(R.id.humanVsHuman)).perform(click());
        onView(withId(R.id.startTheGameButton)).perform(click());

        intended(hasComponent(MainActivity.class.getName()));
    }

    @Test
    public void clickOnButtonSendsToMenuActivityForHvsComp() {
        onView(withId(R.id.enterTTTButton)).perform(click());
        onView(withId(R.id.humanVsComputer)).perform(click());
        onView(withId(R.id.startTheGameButton)).perform(click());

        intended(hasComponent(WinnerActivity.class.getName()));
    }
}

