package com.example.mindsparkdemo.View.DashboardScreen.QuestionStore;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mindsparkdemo.App.MyRoom.ScoreTable;
import com.example.mindsparkdemo.QuestionSet.MCQ;
import com.example.mindsparkdemo.R;
import com.example.mindsparkdemo.SessionReportPage;
import com.example.mindsparkdemo.Utility.AudioSound;
import com.example.mindsparkdemo.Utility.Session.Sessionmanager;
import com.example.mindsparkdemo.Utility.Util;
import com.example.mindsparkdemo.ViewModal.RegisteredUser;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Question extends AppCompatActivity implements View.OnClickListener {

    TextView questionNumber;
    TextView QuestionInstruction;
    ImageView QuestionImg;
    TextView QuestionBottomInst;
    LinearLayout optionA;
    LinearLayout Atext;
    TextView optionAoptionText;
    LinearLayout optionB;
    LinearLayout Btext;
    TextView optionBoptionText;
    LinearLayout optionC;
    LinearLayout Ctext;
    TextView optionCoptionText;
    LinearLayout optionD;
    LinearLayout Dtext;
    TextView optionDoptionText;
    LinearLayout submitbtn;
    LinearLayout donebtn;
    QuestionBank questionBank;
    ArrayList<MCQ> QuestionSet;
    private int currentQuestionNumber = 0;
    private int userResult = 0;
    private boolean Aclick = false;
    private boolean Bclick = false;
    private boolean Cclick = false;
    private boolean Dclick = false;
    private RegisteredUser registeredUser;
    private AudioSound audioSound;
    private LinearLayout InstVoice;
    private LinearLayout voiceOver;
    private ImageView buddyimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        init();
        setDataIntoFrame();
    }

    private void resetQuestionContainer(){
        if(audioSound != null){
            audioSound.stopPlaying();
        }
        buddyimg.setImageResource(R.drawable.buddy_sparkie_higher);
        Btext.setBackgroundResource(R.drawable.default_option);
        Atext.setBackgroundResource(R.drawable.default_option);
        Ctext.setBackgroundResource(R.drawable.default_option);
        Dtext.setBackgroundResource(R.drawable.default_option);
        voiceOver.setVisibility(View.GONE);
        InstVoice.setVisibility(View.GONE);
        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
        Aclick = false;
        Bclick =false;
        Cclick =false;
        Dclick=false;
    }

    private void ennableOptionsVisibility(){
        optionA.setVisibility(View.VISIBLE);
        optionB.setVisibility(View.VISIBLE);
        optionC.setVisibility(View.VISIBLE);
        optionD.setVisibility(View.VISIBLE);
    }

    private void setDataIntoFrame() {
        resetQuestionContainer();
        if(currentQuestionNumber>=0 && QuestionSet.size()>currentQuestionNumber){
            MCQ mcq = QuestionSet.get(currentQuestionNumber);
            questionNumber.setText("" + mcq.getQuestion_num());
            QuestionInstruction.setText(mcq.getQuestion_body());

            if(mcq.getQuestion_img() != -1){
                QuestionImg.setVisibility(View.VISIBLE);
                Glide.with(this)
                        .load(mcq.getQuestion_img())
                        .centerCrop()
                        .placeholder(R.drawable.boy)
                        .into(QuestionImg);
            }else{
                QuestionImg.setVisibility(View.GONE);
            }

            if(mcq.isQuesInst()){
                InstVoice.setVisibility(View.VISIBLE);
                audioSound = new AudioSound();
                audioSound.startAudioStream(mcq.getQuesInstUrl());
            }

            if(mcq.isQuesVoice()){
                voiceOver.setVisibility(View.VISIBLE);
            }

            InstVoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioSound = new AudioSound();
                    audioSound.startAudioStream(mcq.getQuesInstUrl());
                }
            });

            voiceOver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioSound = new AudioSound();
                    audioSound.startAudioStream(mcq.getGetVoiceUrl());
                }
            });

            if(mcq.getQuestion_body() != null && !mcq.getQuestion_body().isEmpty()){
                QuestionBottomInst.setText(mcq.getQuestion_desc());
            }else{
                QuestionBottomInst.setVisibility(View.GONE);
            }

            //Glide.with(this).load(mcq.getQuestion_img()).into(QuestionImg);
            if(mcq.getTotal_mcq_options() == 2){
                ennableOptionsVisibility();
                optionAoptionText.setText(mcq.getMcq_1());
                optionBoptionText.setText(mcq.getMcq_2());
                optionC.setVisibility(View.GONE);
                optionD.setVisibility(View.GONE);
            }else if(mcq.getTotal_mcq_options() == 3){
                ennableOptionsVisibility();
                optionAoptionText.setText(mcq.getMcq_1());
                optionBoptionText.setText(mcq.getMcq_2());
                optionCoptionText.setText(mcq.getMc1_3());
                optionD.setVisibility(View.GONE);
            }else if(mcq.getTotal_mcq_options() == 4){
                ennableOptionsVisibility();
                optionAoptionText.setText(mcq.getMcq_1());
                optionBoptionText.setText(mcq.getMcq_2());
                optionCoptionText.setText(mcq.getMc1_3());
                optionDoptionText.setText(mcq.getMcq_4());
            }
        }
    }

    private void init(){
        questionNumber = findViewById(R.id.questionNumber);
        QuestionInstruction = findViewById(R.id.QuestionInst);
        QuestionImg = findViewById(R.id.questionImg);
        QuestionBottomInst = findViewById(R.id.QuestionbottomInst);
        optionA = findViewById(R.id.optionA);
        Atext = findViewById(R.id.Atext);
        optionAoptionText = findViewById(R.id.optionAoptionText);
        optionB = findViewById(R.id.optionB);
        Btext = findViewById(R.id.Btext);
        optionBoptionText = findViewById(R.id.optionBoptionText);
        optionC = findViewById(R.id.optionC);
        Ctext = findViewById(R.id.Ctext);
        optionCoptionText = findViewById(R.id.optionCoptionText);
        optionD = findViewById(R.id.optionD);
        Dtext = findViewById(R.id.Dtext);
        optionDoptionText = findViewById(R.id.optionDoptionText);
        donebtn = findViewById(R.id.donebtn);
        QuestionSet = new ArrayList<>();
        submitbtn = findViewById(R.id.submitbtn);
        submitbtn.setOnClickListener(this);
        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);
        donebtn.setOnClickListener(this);
        registeredUser = new RegisteredUser(this);
        questionBank = new QuestionBank();
        QuestionSet = questionBank.questionLit;
        audioSound = new AudioSound();
        InstVoice = findViewById(R.id.InstVoice);
        buddyimg = findViewById(R.id.buddyimg);
        voiceOver = findViewById(R.id.voiceOver);

       // audioSound.startAudioStream("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/Listen%20and%20choose%20the%20correct%20option.mp3");
    }
    private void redirect(){
        boolean res = registeredUser.isScoreDataExist(Sessionmanager.get().getUserName());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        String d = Util.diff(Sessionmanager.get().getStartTime(), currentTime);
        if(audioSound != null){
            audioSound.stopPlaying();
        }
        if(res){
            registeredUser.UpdateScoreData(userResult,QuestionSet.size()-userResult,Sessionmanager.get().getUserName(),d);
        }else{
            ScoreTable scoreTable = new ScoreTable();
            scoreTable.setCorrect(userResult);
            scoreTable.setIncorrect(QuestionSet.size()-userResult);
            scoreTable.setUsername(Sessionmanager.get().getUserName());
            scoreTable.setTimeTaken(d);
            registeredUser.insertScoreTable(scoreTable);
        }
        Intent intent = new Intent(this, SessionReportPage.class);
        startActivity(intent);
        finish();;
    }


    private void submitAttemptQuestion() {
        Log.d("result"," " + userResult);
        Log.d("total"," " + QuestionSet.size());

        if(currentQuestionNumber >= QuestionSet.size()){
            redirect();
        }else{
            if(!Aclick && !Bclick && !Cclick && !Dclick){
                Snackbar.make(getWindow().getDecorView().getRootView(),"Please select your answer", Snackbar.LENGTH_LONG).show();
            }else {

                currentQuestionNumber++;
                if(currentQuestionNumber == QuestionSet.size()) redirect();
                setDataIntoFrame();
            }
        }
    }
    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.submitbtn :
                    submitAttemptQuestion();
                    break;
                case R.id.optionA:
                    Aclick = true;
                    validateAns();
                    break;
                case R.id.optionB:
                    Bclick = true;
                    validateAns();
                    break;
                case R.id.optionC:
                    Cclick = true;
                    validateAns();
                    break;
                case R.id.optionD:
                    Dclick = true;
                    validateAns();
                    break;
                case R.id.donebtn:
                    redirect();
                    break;
            }
    }


    private void onSelect(boolean status){
        if(status){
            MediaPlayer mpintro = MediaPlayer.create(this, R.raw.correct);
            mpintro.start();
            buddyimg.setImageResource(R.drawable.buddy_sparkie_higher);
        }else{
            MediaPlayer mpintro = MediaPlayer.create(this,  R.raw.incorrect);
            mpintro.start();
            buddyimg.setImageResource(R.drawable.buddy_sad);
        }
    }

    private void validateAns() {
        Log.d("path",""+Environment.getExternalStorageDirectory().getPath());
        int ans = 0;
        if(Aclick) ans = 1;
        else if(Bclick) ans = 2;
        else if(Cclick) ans = 3;
        else ans = 4;
        if(ans == QuestionSet.get(currentQuestionNumber).getResult()){
            userResult++;
            changedColor(true);
            onSelect(true);
        }else{
            changedColor(false);
            onSelect(false);
        }
    }

    private void changedColor(boolean res) {
        if(Aclick){
            if(res){
                Atext.setBackgroundResource(R.drawable.correct_option);
            }else{
                Atext.setBackgroundResource(R.drawable.incorrect_option);
            }
        }else if(Bclick){
            if(res){
                Btext.setBackgroundResource(R.drawable.correct_option);
            }else{
                Btext.setBackgroundResource(R.drawable.incorrect_option);
            }
        }else if(Cclick){
            if(res){
                Ctext.setBackgroundResource(R.drawable.correct_option);
            }else{
                Ctext.setBackgroundResource(R.drawable.incorrect_option);
            }
        }else{
            if(res){
                Dtext.setBackgroundResource(R.drawable.correct_option);
            }else{
                Dtext.setBackgroundResource(R.drawable.incorrect_option);
            }
        }
        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);
    }
}