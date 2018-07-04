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
public class MainActivityThroughPlayAgainButtonToWelcome {

    @Rule
    public IntentsTestRule<MainActivity> winnerActivityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickOnButtonSendsToMainActivityForWonGame() {
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_4)).perform(click());
        onView(withId(R.id.place_number_8)).perform(click());
        onView(withId(R.id.place_number_5)).perform(click());
        onView(withId(R.id.place_number_9)).perform(click());
        onView(withId(R.id.place_number_6)).perform(click());
        onView(withId(R.id.playAgainButton)).perform(click());

        intended(hasComponent(WelcomeActivity.class.getName()));
    }

    @Test
    public void clickOnButtonSendsToMainActivityForTieGame() {
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_5)).perform(click());
        onView(withId(R.id.place_number_2)).perform(click());
        onView(withId(R.id.place_number_3)).perform(click());
        onView(withId(R.id.place_number_7)).perform(click());
        onView(withId(R.id.place_number_4)).perform(click());
        onView(withId(R.id.place_number_6)).perform(click());
        onView(withId(R.id.place_number_9)).perform(click());
        onView(withId(R.id.place_number_8)).perform(click());
        onView(withId(R.id.playAgainButton)).perform(click());

        intended(hasComponent(WelcomeActivity.class.getName()));
    }
}