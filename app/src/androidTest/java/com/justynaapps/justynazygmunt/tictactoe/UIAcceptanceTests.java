package com.justynaapps.justynazygmunt.tictactoe;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UIAcceptanceTests {

    @Rule
    public IntentsTestRule<WelcomeActivity> welcomeActivityTestRule =
            new IntentsTestRule<>(WelcomeActivity.class);

    @Test
    public void welcomeActivityToAWonHumanVsHumanGame() {
        onView(withId(R.id.enterTTTButton)).perform(click());
        onView(withId(R.id.playerOneHuman)).perform(click());
        onView(withId(R.id.playerTwoHuman)).perform(click());
        onView(withId(R.id.startTheGameButton)).perform(click());
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_4)).perform(click());
        onView(withId(R.id.place_number_2)).perform(click());
        onView(withId(R.id.place_number_5)).perform(click());
        onView(withId(R.id.place_number_3)).perform(click());

        intended(hasComponent(WinnerActivity.class.getName()));
        onView(withId(R.id.playerSign)).check(matches(withText("X")));
    }

    @Test
    public void welcomeActivityToTieHumanVsComputerGame() {
        onView(withId(R.id.enterTTTButton)).perform(click());
        onView(withId(R.id.playerOneHuman)).perform(click());
        onView(withId(R.id.playerTwoComputer)).perform(click());
        onView(withId(R.id.startTheGameButton)).perform(click());
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_2)).perform(click());
        onView(withId(R.id.place_number_7)).perform(click());
        onView(withId(R.id.place_number_6)).perform(click());
        onView(withId(R.id.place_number_9)).perform(click());

        intended(hasComponent(TieActivity.class.getName()));
        onView(withId(R.id.drawMessage)).check(matches(withText("It's a draw!")));
    }

    @Test
    public void welcomeActivityToTieComputerVsHumanGame() {
        onView(withId(R.id.enterTTTButton)).perform(click());
        onView(withId(R.id.playerOneComputer)).perform(click());
        onView(withId(R.id.playerTwoHuman)).perform(click());
        onView(withId(R.id.startTheGameButton)).perform(click());
        onView(withId(R.id.place_number_5)).perform(click());
        onView(withId(R.id.place_number_3)).perform(click());
        onView(withId(R.id.place_number_4)).perform(click());
        onView(withId(R.id.place_number_8)).perform(click());

        intended(hasComponent(TieActivity.class.getName()));
        onView(withId(R.id.drawMessage)).check(matches(withText("It's a draw!")));
    }
}
