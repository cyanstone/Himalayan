package com.my.cyanstone.himalayan;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by 95199 on 2016/3/13.
 */
public class HimalayanApplication extends Application {
    public static Context sContext;
    private RefWatcher mWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        mWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getWatcher(Context context) {
        HimalayanApplication application = (HimalayanApplication) context.getApplicationContext();
        return application.mWatcher;
    }
}
