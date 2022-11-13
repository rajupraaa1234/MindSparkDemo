package com.example.mindsparkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.mindsparkdemo.App.MyRoom.TeacherTable;
import com.example.mindsparkdemo.LandingPage;
import com.example.mindsparkdemo.Utility.Session.AppConstant;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.View.DashboardScreen.Dashboard;
import com.example.mindsparkdemo.View.DashboardScreen.TeacherDashBoardScreen;


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
            Intent i1=new Intent(MainActivity.this, Dashboard.class);
            startActivity(i1);
            finish();
        }else{
            Intent i=new Intent(MainActivity.this, LandingPage.class);
            startActivity(i);
            finish();
        }
    }
}