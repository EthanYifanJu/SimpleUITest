package Espresso;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.test.espresso.Root;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.example.loginforuitest.R;
import com.example.loginforuitest.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

@LargeTest
public class UITest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void isDisplayed(){
        onView(withId(R.id.username)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void cannotLogin(){
        onView(withId(R.id.username)).perform(typeText("sdjsdifs"));
        onView(withId(R.id.password)).perform(typeText("sdjifdsijfjisdf"));
        closeSoftKeyboard();
        onView(withId(R.id.login)).perform(click());

        onView(withText("Wrong username or password")).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void login(){
        onView(withId(R.id.username)).perform(typeText("COMP6442"));
        onView(withId(R.id.password)).perform(typeText("123456"));
        closeSoftKeyboard();
        onView(withId(R.id.login)).perform(click());

        onView(withText("Hello world!")).check(matches(ViewMatchers.isDisplayed()));
    }
}
