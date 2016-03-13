package com.my.cyanstone.himalayan.net;

import okhttp3.OkHttpClient;

/**
 * Created by 95199 on 2016/3/11.
 */
public class MyHttpClient {
    private static OkHttpClient sOkHttpClient = new OkHttpClient();

    public static OkHttpClient getHttpClient() {
        return sOkHttpClient;
    }
}
