package com.example.mindsparkdemo.App.MyRoom;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MyDataAccessObjects {

    @Insert
    public void insert(RegisterUser registerUser);

    @Query("SELECT * FROM Register_users WHERE username = :username")
    int isDataExist(String username);

    @Query("SELECT * FROM Register_users WHERE username = :username AND User_password =:password")
    int isPassWordMatch(String username,String password);

    @Insert
    public void insertScoreTable(ScoreTable scoreTable);


    @Query("SELECT * FROM Score_Table WHERE username = :username")
    int isScoreDataExist(String username);

    @Query("SELECT * FROM Score_Table WHERE username = :username")
    public ScoreTable getScoreData(String username);

    @Query("UPDATE Score_Table SET correct = :cor,incorrect = :incor  WHERE username = :username")
    public void UpdateScoreData(int cor,int incor,String username);
}
