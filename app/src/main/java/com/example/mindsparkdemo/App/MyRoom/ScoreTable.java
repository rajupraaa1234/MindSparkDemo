package com.example.mindsparkdemo.App.MyRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Score_Table")
public class ScoreTable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "username")
    private String Username;

    @ColumnInfo(name = "correct")
    private int Correct;

    @ColumnInfo(name = "incorrect")
    private int Incorrect;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public int getCorrect() {
        return Correct;
    }

    public int getIncorrect() {
        return Incorrect;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setCorrect(int correct) {
        Correct = correct;
    }

    public void setIncorrect(int incorrect) {
        Incorrect = incorrect;
    }
}
