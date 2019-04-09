package com.company1075.Beira.app;

import android.content.Context;

import com.com1075.library.base.BaseApplication;

public class BeiraApplication extends BaseApplication {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
