package com.example.anapaula.quilombolaappv4;

import android.app.Application;
import android.content.Context;

public class GlobalApplication extends Application {

    private static Context appContext;
    private static Context baseAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        baseAppContext = getBaseContext();

        /* If you has other classes that need context object to initialize when application is created,
         you can use the appContext here to process. */
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static Context getAppBaseContext() {
        return baseAppContext;
    }
}
