package com.ncsoft.platform.javamonitoringapp;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by skwangh on 2015-12-25.
 */
public class JavaMonitoringApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }

}
