package com.example.mindsparkdemo.App;

import android.app.Application;



public class appController extends Application {
    private static appController instance;
    public static synchronized appController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //NetworkHandler.isConnected = Utility.getNetworkState(this);
    }
}
