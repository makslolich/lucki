package com.superseven.goose;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class ApplicationO extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.fullyInitialize();
        AppEventsLogger.activateApp(this);
    }
}
