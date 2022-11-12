package com.example.mindsparkdemo.View.DashboardScreen;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mindsparkdemo.App.MyRoom.ScoreTable;
import com.example.mindsparkdemo.LoginScreen;
import com.example.mindsparkdemo.R;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.View.DashboardScreen.QuestionStore.Question;
import com.example.mindsparkdemo.ViewModal.RegisteredUser;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    TextView userTxt;
    DrawerLayout drawerLayout;
    ImageView drawerIcon;
    NavigationView navigationView;
    LinearLayout logoutBtn;
    LinearLayout homebtn;
    LinearLayout topics;
    TextView coin;
    private RegisteredUser registeredUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    private void init(){
        userTxt = findViewById(R.id.userTxt);
        userTxt.setText(Sessionmanager.get().getUserName());
        drawerIcon = findViewById(R.id.drawerIcon);
        drawerIcon.setOnClickListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_main);
        navigationView = findViewById(R.id.nav_bar);
        logoutBtn = findViewById(R.id.logoutbtn);
        homebtn = findViewById(R.id.homebtn);
        logoutBtn.setOnClickListener(this);
        homebtn.setOnClickListener(this);
        topics=findViewById(R.id.TopicLinear);
        topics.setOnClickListener(this);
        coin = findViewById(R.id.coinid);
        registeredUser = new RegisteredUser(this);
        ScoreTable scoreTable = registeredUser.getScoreData(Sessionmanager.get().getUserName());

        if(scoreTable != null)
            coin.setText(""+scoreTable.getCorrect());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.drawerIcon :
                 clickOnDrawerIcon();
                break;
            case R.id.logoutbtn:
                logout();
                break;

            case R.id.homebtn:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.TopicLinear:
                RedirectToQuestion();
                break;
        }
    }

    private void clickOnDrawerIcon(){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void logout(){
        Sessionmanager.get().clear();
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
        finish();
    }

    private void RedirectToQuestion(){
        Intent intent = new Intent(this, Question.class);
        startActivity(intent);
        finish();
    }
}