package com.example.mindsparkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.mindsparkdemo.LandingPage;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.View.DashboardScreen.Dashboard;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkForNewUser();
            }
        }, 3000);
    }
    private void checkForNewUser(){
        if(Sessionmanager.get().isLoggedIn()){
            Intent i=new Intent(MainActivity.this, Dashboard.class);
            startActivity(i);
            finish();
        }else{
            Intent i=new Intent(MainActivity.this, LoginScreen.class);
            startActivity(i);
            finish();
        }
    }
}