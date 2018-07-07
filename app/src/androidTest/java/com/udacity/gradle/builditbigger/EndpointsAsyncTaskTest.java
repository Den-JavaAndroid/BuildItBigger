package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.example.jokelib.JokeTelling;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testExecuteMethod() throws Exception {
        Context context = mainActivityActivityTestRule.getActivity().getApplicationContext();
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(context);
        endpointsAsyncTask.execute();
        String jokeFromLib = endpointsAsyncTask.get(10, TimeUnit.SECONDS);
        Assert.assertNotNull(jokeFromLib);

        JokeTelling jokeTelling = new JokeTelling();
        String[] jockes = jokeTelling.getJokes();
        Assert.assertTrue("Unexpected value for d.getFormType(): " + jokeFromLib,
                jokeFromLib.equals(jockes[0]) ||
                        jokeFromLib.equals(jockes[1]) ||
                        jokeFromLib.equals(jockes[2]));
    }
}