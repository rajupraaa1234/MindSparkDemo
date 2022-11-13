package com.example.mindsparkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mindsparkdemo.View.DashboardScreen.TeacherDashBoardScreen;

public class LandingPage extends AppCompatActivity implements View.OnClickListener{

    LinearLayout student;
    LinearLayout teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        init();
    }

    private void init(){
        student = findViewById(R.id.student);
        teacher = findViewById(R.id.teacher);
        student.setOnClickListener(this);
        teacher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student:
                Intent intent = new Intent(this,LoginScreen.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", "student");
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                break;
            case R.id.teacher:
                Intent intent1 = new Intent(this, LoginScreen.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("user", "teacher");
                intent1.putExtras(bundle1);
                startActivity(intent1);
                finish();
                break;
        }
    }
}