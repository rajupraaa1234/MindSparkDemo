package com.example.mindsparkdemo.App.MyRoom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Register_users")
public class RegisterUser {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "username")
    private String Username;

    @ColumnInfo(name = "User_password")
    private String password;


    public void setUsername(@NonNull String username) {
        Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }


}
