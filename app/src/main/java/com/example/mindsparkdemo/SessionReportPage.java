package com.example.mindsparkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.LinkAddress;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mindsparkdemo.App.MyRoom.ScoreTable;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.Utility.Util;
import com.example.mindsparkdemo.View.DashboardScreen.Dashboard;
import com.example.mindsparkdemo.ViewModal.RegisteredUser;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

public class SessionReportPage extends AppCompatActivity {

    LinearLayout done_btn;
    TextView score;
    TextView correctCount;
    TextView wrongCount;
    TextView youdid;
    TextView timeTaken;
    private RegisteredUser registeredUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_report_page);
        init();
        updateData();
    }

    private void redirect(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
        finish();;
    }

    private void init(){
        done_btn = findViewById(R.id.donebtn1);
        score = findViewById(R.id.score);
        correctCount = findViewById(R.id.correctCount);
        wrongCount = findViewById(R.id.wrongCount);
        registeredUser = new RegisteredUser(this);
        youdid = findViewById(R.id.youdid);
        timeTaken = findViewById(R.id.timeTaken);
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect();
            }
        });
    }
    private void updateData(){
        ScoreTable scoreTable = registeredUser.getScoreData(Sessionmanager.get().getUserName());
            score.setText("your score is : "+scoreTable.getCorrect());
            correctCount.setText(""+scoreTable.getCorrect());
            wrongCount.setText(""+scoreTable.getIncorrect());
            timeTaken.setText(""+ scoreTable.getTimeTaken());
            int total = scoreTable.getCorrect()+scoreTable.getIncorrect();
            String str = "you did " + total + " Questions";
            youdid.setText(str);
    }
}