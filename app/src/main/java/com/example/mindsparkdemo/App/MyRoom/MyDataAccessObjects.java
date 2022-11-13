package com.example.mindsparkdemo.App.MyRoom;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

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

    @Query("SELECT * FROM Score_Table")
    public List<ScoreTable> getScoreData();



    @Query("UPDATE Score_Table SET correct = :cor,incorrect = :incor,time = :tm  WHERE username = :username")
    public void UpdateScoreData(int cor,int incor,String username,String tm);


    @Insert
    public void insertTeacherEntry(TeacherTable teacherTable);

    @Query("SELECT * FROM Teacher WHERE TeacherUsername = :username")
    int isTeacherExist(String username);

    @Query("SELECT * FROM Teacher WHERE TeacherUsername = :username AND TeacherPassword =:password")
    int isTeacherPassWordMatch(String username,String password);



}
