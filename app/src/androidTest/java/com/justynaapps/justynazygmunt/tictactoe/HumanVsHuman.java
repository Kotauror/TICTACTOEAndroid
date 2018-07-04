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
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HumanVsHuman {

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
    public void clickedPlaceIsMarkedWithX() {
        onView(withId(R.id.place_number_1)).perform(click());

        onView(withId(R.id.place_number_1)).check(matches(withText("X")));
    }

    @Test
    public void clickedPlaceIsMarkedWithO() {
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_2)).perform(click());

        onView(withId(R.id.place_number_2)).check(matches(withText("O")));
    }

    @Test
    public void userCannotChangeOnceClickedPlace() {
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_1)).perform(click());

        onView(withId(R.id.place_number_1)).check(matches(withText("X")));
    }

    @Test
    public void userCannotTickAPlaceOnceGameIsOver() {
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_4)).perform(click());
        onView(withId(R.id.place_number_2)).perform(click());
        onView(withId(R.id.place_number_5)).perform(click());
        onView(withId(R.id.place_number_3)).perform(click());
        onView(withId(R.id.place_number_6)).perform(click());

        onView(withId(R.id.place_number_6)).check(matches(withText("6")));
    }

    @Test
    public void firstUserGetRightMessageAfterMove() {
        onView(withId(R.id.place_number_1)).perform(click());

        onView(withId(R.id.messages)).check(matches(withText("Player X picked position 1")));
    }

    @Test
    public void secondUserGetRightMessageAfterMove() {
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_2)).perform(click());

        onView(withId(R.id.messages)).check(matches(withText("Player O picked position 2")));
    }

    @Test
    public void userIsInformOfAWonGame() {
        onView(withId(R.id.place_number_1)).perform(click());
        onView(withId(R.id.place_number_4)).perform(click());
        onView(withId(R.id.place_number_2)).perform(click());
        onView(withId(R.id.place_number_5)).perform(click());
        onView(withId(R.id.place_number_3)).perform(click());
        onView(withId(R.id.place_number_6)).perform(click());

        onView(withId(R.id.playerSign)).check(matches(withText("X")));
    }
}


