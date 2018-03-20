package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Time;
import java.util.concurrent.ExecutionException;

import andreas.androidlibraryjoke.DisplayJokeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static org.hamcrest.core.IsNot.not;



@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest  {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void Noempty() throws ExecutionException, InterruptedException {

        EndpointsAsyncTask connectedTest = new EndpointsAsyncTask(activityActivityTestRule.getActivity().getApplicationContext());
        connectedTest.execute();
        String jokes = connectedTest.get();
        if(jokes.equals("connect timed out"))
        {
            jokes=null;
        }
        assertNotNull(jokes);
    }


}
