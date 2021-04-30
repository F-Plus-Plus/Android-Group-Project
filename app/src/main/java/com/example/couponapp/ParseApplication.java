package com.example.couponapp;

import com.parse.Parse;
import android.app.Application;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(BuildConfig.applicationID)
                .clientKey(BuildConfig.clientKey)
                .server(BuildConfig.server)
                .build()
        );
    }
}