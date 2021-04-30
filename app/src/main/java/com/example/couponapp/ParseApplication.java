package com.example.couponapp;

import com.parse.Parse;
import android.app.Application;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("xjxio43voNzu6TcH41TMg2jmDmstOO5CQwOcKgDU")
                .clientKey("gPkS2wI66L8L1S9zCas7CwXUZ5K0kIfIdaAZIdg5")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}