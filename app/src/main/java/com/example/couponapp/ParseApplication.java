package com.example.couponapp;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as app is created
    @Override
    public void onCreate() {
        super.onCreate();

        //Register your parse models
        ParseObject.registerSubclass(Post.class);

        // Register your parse models
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(BuildConfig.applicationID)
                .clientKey(BuildConfig.clientKey)
                .server(BuildConfig.server).build()
        );
    }
}