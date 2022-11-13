package com.example.mindsparkdemo.App.MyRoom;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Teacher")
public class TeacherTable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "TeacherUsername")
    private String Username;

    @ColumnInfo(name = "TeacherPassword")
    private String TeacherPassWord;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getTeacherPassWord() {
        return TeacherPassWord;
    }

    public void setTeacherPassWord(String teacherPassWord) {
        TeacherPassWord = teacherPassWord;
    }
}
