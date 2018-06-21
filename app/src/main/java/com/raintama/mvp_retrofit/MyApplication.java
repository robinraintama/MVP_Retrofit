package com.raintama.mvp_retrofit;

import android.app.Application;

import com.raintama.mvp_retrofit.connection.User;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public String getAccessToken() {
        return "";
    }

    public void setAccessToken(String accessToken) {

    }
}
