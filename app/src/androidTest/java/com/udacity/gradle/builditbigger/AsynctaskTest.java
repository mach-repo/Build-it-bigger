package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by merouane on 08/02/2018.
 */

public class AsynctaskTest extends ApplicationTestCase<Application> {

    String mJsonString = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public AsynctaskTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    @Test
    public void testTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
            task.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String jsonString, Exception e) {
                mJsonString = jsonString;
                mError = e;
                signal.countDown();
            }
        }).execute();
        signal.await();

        // result should not be empty
        assertFalse(TextUtils.isEmpty(mJsonString));
    }
}