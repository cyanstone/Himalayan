package com.my.cyanstone.himalayan.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.my.cyanstone.himalayan.HimalayanApplication;

/**
 * Created by 95199 on 2016/3/15.
 */
public class SystemInfoUtils {
    public static final String SCREEN_WIDTH = "screenWidth";
    private static int screenWidth = 0;
    public static int getScreenWidth(Context context) {
        screenWidth = context.getSharedPreferences("system_info",Context.MODE_PRIVATE).getInt(SCREEN_WIDTH,0);
        if(screenWidth == 0) {
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            manager.getDefaultDisplay().getMetrics(dm);
            screenWidth = dm.widthPixels;
            SharedPreferences.Editor editor = context.getSharedPreferences("system_info",Context.MODE_PRIVATE).edit();
            editor.putInt(SCREEN_WIDTH,screenWidth)
                    .commit();
        }
        return screenWidth;
    }
}
