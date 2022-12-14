package com.example.mindsparkdemo.App.MyRoom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RegisterUser.class,ScoreTable.class,TeacherTable.class},version = 6,exportSchema = true)
public abstract class MyDataBase extends RoomDatabase {
    public abstract MyDataAccessObjects myDataAccsessObject();
}
