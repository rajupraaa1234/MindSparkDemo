package com.example.mindsparkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mindsparkdemo.App.MyRoom.RegisterUser;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.View.DashboardScreen.Dashboard;
import com.example.mindsparkdemo.ViewModal.RegisteredUser;
import com.google.android.material.snackbar.Snackbar;

import static com.example.mindsparkdemo.R.drawable.disable_btn;
import static com.example.mindsparkdemo.R.drawable.enablebtn;

public class SignupSceen extends AppCompatActivity implements View.OnClickListener {

    LinearLayout bakcbtn;
    EditText username;
    EditText password;
    TextView signupbtn;
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
        setContentView(R.layout.activity_signup_sceen);
        init();
    }

    private void init(){
        bakcbtn = findViewById(R.id.backbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signupbtn = findViewById(R.id.loginbtn);
        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        signupbtn.setOnClickListener(this);
        bakcbtn.setOnClickListener(this);
        registeredUser = new RegisteredUser(this);
    }

    private void checkallcompleted(){
        String user =  username.getText().toString();
        String pass = password.getText().toString();
        if(user.length() > 3 && pass.length()>3){
            signupbtn.setBackgroundResource(enablebtn);
            signupbtn.setEnabled(true);
            signupbtn.setTextColor(Color.parseColor("#FFFFFFFF"));
        }else{
            signupbtn.setEnabled(false);
            signupbtn.setBackgroundResource(disable_btn);
            signupbtn.setTextColor(Color.parseColor("#FF000000"));
        }
    }

    private void signUpApi(){
        String user =  username.getText().toString();
        String pass = password.getText().toString();
        boolean res = registeredUser.UserExist(user);
        if(res){
            Snackbar.make(getWindow().getDecorView().getRootView(),"User Already Registered", Snackbar.LENGTH_LONG).show();
        }else{
            RegisterUser registerUser = new RegisterUser();
            registerUser.setUsername(user);
            registerUser.setPassword(pass);
            boolean response = registeredUser.inserOwnertdata(registerUser);
            if(response){
                Snackbar.make(getWindow().getDecorView().getRootView(),"User Registration Successfully...", Snackbar.LENGTH_LONG).show();
                Sessionmanager.get().setLogin(true);
                Sessionmanager.get().setUserName(user);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(SignupSceen.this, Dashboard.class);
                        startActivity(i);
                        finish();
                    }
                }, 1000);
            }else{
                Snackbar.make(getWindow().getDecorView().getRootView(),"Somthing is wrong...", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginbtn:
                signUpApi();
                break;
        }
    }
}