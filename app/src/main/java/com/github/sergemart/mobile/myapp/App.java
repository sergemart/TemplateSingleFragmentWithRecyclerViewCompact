package com.github.sergemart.mobile.myapp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;


public class App extends Application {

    @SuppressLint("StaticFieldLeak")                                                                // ok for the application context
    private static Context sContext;


    /**
     * Make sure that all the calls is occurred after the application onCreate()
     */
    public static Context getContext() {
        return sContext;
    }


    // ---------------------------

    public void onCreate() {
        super.onCreate();
        sContext = super.getApplicationContext();
    }


}
