package com.overseas.overseas;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MyApplication extends Application {
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }


    public static Context getGloableContext() {
        return application.getApplicationContext();
    }

}

