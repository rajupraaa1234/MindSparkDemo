package com.example.mindsparkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mindsparkdemo.App.MyRoom.RegisterUser;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.View.DashboardScreen.Dashboard;
import com.example.mindsparkdemo.ViewModal.RegisteredUser;
import com.google.android.material.snackbar.Snackbar;

import static com.example.mindsparkdemo.R.drawable.backbtn;
import static com.example.mindsparkdemo.R.drawable.disable_btn;
import static com.example.mindsparkdemo.R.drawable.enablebtn;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener{

    EditText username;
    EditText password;
    TextView loginBtn;
    TextView signup;
    private RegisteredUser registeredUser;


    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkallcompleted();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        init();
    }

    private void init(){
        username = findViewById(R.id.lusername);
        password = findViewById(R.id.lpassword);
        loginBtn = findViewById(R.id.lloginbtn);
        signup = findViewById(R.id.lsignup);
        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        loginBtn.setOnClickListener(this);
        signup.setOnClickListener(this);
        registeredUser = new RegisteredUser(this);
        loginBtn.setEnabled(false);
    }

    @SuppressLint("ResourceAsColor")
    private void checkallcompleted(){
         String user =  username.getText().toString();
         String pass = password.getText().toString();
         if(user.length() > 3 && pass.length()>3){
             loginBtn.setBackgroundResource(enablebtn);
             loginBtn.setEnabled(true);
             loginBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
         }else{
             loginBtn.setEnabled(false);
             loginBtn.setBackgroundResource(disable_btn);
             loginBtn.setTextColor(Color.parseColor("#FF000000"));
         }
    }
    private void checkForLogin(){
        String user =  username.getText().toString();
        String pass = password.getText().toString();
        boolean res = registeredUser.UserExist(user);
        if(res){
            boolean Response = registeredUser.PassWordMathc(user,pass);
            if(Response){
                Sessionmanager.get().setUserName(user);
                Sessionmanager.get().setLogin(true);
                Intent intent = new Intent(this, Dashboard.class);
                Snackbar.make(getWindow().getDecorView().getRootView(),"User logged in successfully...", Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }else {
                Snackbar.make(getWindow().getDecorView().getRootView(),"Password Incorrect", Snackbar.LENGTH_LONG).show();
            }
        }else{
            Snackbar.make(getWindow().getDecorView().getRootView(),"User Not Exist", Snackbar.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lloginbtn:
                checkForLogin();
                break;
            case R.id.lsignup:
                Intent intent = new Intent(this,SignupSceen.class);
                startActivity(intent);
                finish();
                break;
        }

    }
}