package com.example.mindsparkdemo.ViewModal;

import android.content.Context;

import androidx.room.Room;

import com.example.mindsparkdemo.App.MyRoom.MyDataBase;
import com.example.mindsparkdemo.App.MyRoom.RegisterUser;
import com.example.mindsparkdemo.App.MyRoom.ScoreTable;


public class RegisteredUser {
    MyDataBase myDataBase;
    public RegisteredUser(Context context){
        myDataBase= Room.databaseBuilder(context,MyDataBase.class,"userdb").allowMainThreadQueries().build();
    }

    public boolean inserOwnertdata(RegisterUser registerUser){
        String username=registerUser.getUsername();
        int res=myDataBase.myDataAccsessObject().isDataExist(username);
        if(res==0){
            myDataBase.myDataAccsessObject().insert(registerUser);
            return true;
        }else{
            return false;
        }
    }

    public boolean UserExist(String username){
        int res=myDataBase.myDataAccsessObject().isDataExist(username);
        if(res==0){
            return false;
        }else{
            return true;
        }
    }

    public boolean PassWordMathc(String username, String pass){
        int res=myDataBase.myDataAccsessObject().isPassWordMatch(username,pass);
        if(res==0) return false;
        return true;
    }

    public boolean isScoreDataExist(String username){
        int res = myDataBase.myDataAccsessObject().isScoreDataExist(username);
        if(res==0) return false;
        return true;
    }

    public ScoreTable getScoreData(String username){
        return myDataBase.myDataAccsessObject().getScoreData(username);
    }

    public void insertScoreTable(ScoreTable scoreTable){
        myDataBase.myDataAccsessObject().insertScoreTable(scoreTable);
    }

    public void UpdateScoreData(int corr,int incor,String username,String tm){
        myDataBase.myDataAccsessObject().UpdateScoreData(corr,incor,username,tm);
    }
}
