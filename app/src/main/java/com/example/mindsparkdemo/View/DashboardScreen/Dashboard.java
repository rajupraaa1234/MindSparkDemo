package com.example.mindsparkdemo.View.DashboardScreen;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mindsparkdemo.App.Adapter.ScoreDataAdapter;
import com.example.mindsparkdemo.App.MyRoom.ScoreTable;
import com.example.mindsparkdemo.LandingPage;
import com.example.mindsparkdemo.LoginScreen;
import com.example.mindsparkdemo.R;
import com.example.mindsparkdemo.Utility.Session.AppConstant;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.View.DashboardScreen.QuestionStore.Question;
import com.example.mindsparkdemo.ViewModal.RegisteredUser;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    TextView userTxt;
    DrawerLayout drawerLayout;
    ImageView drawerIcon;
    NavigationView navigationView;
    LinearLayout logoutBtn;
    LinearLayout homebtn;
    LinearLayout topics;
    LinearLayout coinLin;
    TextView coin;
    TextView NavuserTxt;
    LinearLayout coinLinD;
    TextView Navcoinid;
    RecyclerView recyclerView;
    private RegisteredUser registeredUser;
    private ScoreDataAdapter scoreDataAdapter;
    TextView nodataavailabale;
    TextView userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    private void ForStudent(){
        coinLin.setVisibility(View.VISIBLE);
        coinLinD.setVisibility(View.VISIBLE);
        topics.setVisibility(View.VISIBLE);
        userType.setText("User Type : Student");
        userType.setTextColor(Color.BLUE);
        ScoreTable scoreTable = registeredUser.getScoreData(Sessionmanager.get().getUserName());
        if(scoreTable != null) {
            coin.setText("" + scoreTable.getCorrect());
            Navcoinid.setText("" + scoreTable.getCorrect());
        }
    }

    private void CollectData() {
        List<ScoreTable> res= registeredUser.getAllScoreData();
        scoreDataAdapter  =new ScoreDataAdapter(this, (ArrayList<ScoreTable>) res);
        recyclerView.setAdapter(scoreDataAdapter);
        if(res.size()==0){
            recyclerView.setVisibility(View.GONE);
            nodataavailabale.setVisibility(View.VISIBLE);
        }else{
            recyclerView.setVisibility(View.VISIBLE);
            nodataavailabale.setVisibility(View.GONE);
        }
    }

    private void ForTeacher(){
        coinLin.setVisibility(View.GONE);
        coinLinD.setVisibility(View.GONE);
        topics.setVisibility(View.GONE);
        CollectData();
        userType.setText("User Type : Teacher");
        userType.setTextColor(Color.RED);
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
        NavuserTxt = findViewById(R.id.NavuserTxt);
        Navcoinid = findViewById(R.id.Navcoinid);
        coinLin = findViewById(R.id.coinLin);
        coinLinD = findViewById(R.id.coinLinD);
        NavuserTxt.setText(Sessionmanager.get().getUserName());
        recyclerView = findViewById(R.id.myrecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nodataavailabale = findViewById(R.id.nodataavailabale);
        userType = findViewById(R.id.userType);

        if(Sessionmanager.get().getUserType().equals(AppConstant.Student)) {
            ForStudent();
        }else{
            ForTeacher();
        }

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
        Intent intent = new Intent(this, LandingPage.class);
        startActivity(intent);
        finish();
    }

    private void RedirectToQuestion(){
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        Sessionmanager.get().setStartTime(currentTime);
        Log.d("raju", currentTime);
        Intent intent = new Intent(this, Question.class);
        startActivity(intent);
        finish();
    }
}