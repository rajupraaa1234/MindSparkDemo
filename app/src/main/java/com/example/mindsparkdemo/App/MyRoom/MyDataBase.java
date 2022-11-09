package com.example.mindsparkdemo.App.MyRoom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RegisterUser.class,ScoreTable.class},version = 5,exportSchema = true)
public abstract class MyDataBase extends RoomDatabase {
    public abstract MyDataAccessObjects myDataAccsessObject();
}
