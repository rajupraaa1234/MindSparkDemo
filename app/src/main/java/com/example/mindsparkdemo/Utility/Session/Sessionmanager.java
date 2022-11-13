package com.example.mindsparkdemo.Utility.Session;

import android.app.Application;

import com.example.mindsparkdemo.App.appController;


public class Sessionmanager {

   // private SharedPreferences sharedPreferences;
    private static Sessionmanager sinstance;

    private PreferenceUtil sharedPreferences;

    private String session;

    private static void init(Application application){
        if(sinstance==null){
            sinstance=  new Sessionmanager(application);
        }
    }

    public static Sessionmanager get(){
        init(appController.getInstance());
        return sinstance;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Sessionmanager(Application application) {
        sharedPreferences = new PreferenceUtil(application);
    }


    public void setLogin(Boolean login){
        sharedPreferences.setBooleanData(AppConstant.App_Login, login);
    }
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(AppConstant.App_Login);
    }

    public void setUserName(String str){
        sharedPreferences.setStringData(AppConstant.Current_UserName,str);
    }
    public String getUserName(){
        return sharedPreferences.getStringData(AppConstant.Current_UserName);
    }

    public void setStartTime(String str){
        sharedPreferences.setStringData(AppConstant.TIME,str);
    }
    public String getStartTime(){
        return sharedPreferences.getStringData(AppConstant.TIME);
    }

    public void setUserType(String str){
        sharedPreferences.setStringData(AppConstant.USER_TYPE,str);
    }
    public String getUserType(){
        return sharedPreferences.getStringData(AppConstant.USER_TYPE);
    }

//
//    public void setFirstName(String fname){
//        sharedPreferences.setStringData(AppConstant.First_Name,fname);
//    }
//
//    public String getFirstName(){
//        return sharedPreferences.getStringData(AppConstant.First_Name);
//    }
//
//    public void setSecondName(String sname){
//        sharedPreferences.setStringData(AppConstant.Second_Name,sname);
//
//    }
//
//    public String getSecondName(){
//        return sharedPreferences.getStringData(AppConstant.Second_Name);
//    }
//
//    public void setPhone(String phone){
//        sharedPreferences.setStringData(AppConstant.Login_Access_Phone,phone);
//    }
//
//    public String getPhone(){
//        return sharedPreferences.getStringData(AppConstant.Login_Access_Phone);
//    }
//
//    public void setAccessToken(String token){
//        sharedPreferences.setStringData(AppConstant.Login_Access_Token,token);
//    }
//
//    public String getAccessToken(){
//        return sharedPreferences.getStringData(AppConstant.Login_Access_Token);
//    }
//
//
//    public void setLoginImage(String image){
//        sharedPreferences.setStringData(AppConstant.Login_Image,image);
//    }
//
//    public String getLoginImage(){
//        return sharedPreferences.getStringData(AppConstant.Login_Image);
//    }
//
//
//    public void setSocialId(String socialId){
//        sharedPreferences.setStringData(AppConstant.SOCIAL_ID,socialId);
//    }
//
//    public String getSocialId(){
//        return sharedPreferences.getStringData(AppConstant.SOCIAL_ID);
//    }
//
//    public void setCountryCode(String ccode){
//        sharedPreferences.setStringData(AppConstant.CountryCode,ccode);
//    }
//
//
//
//    public void SetSocialLogin(Boolean issocial){
//        sharedPreferences.setBooleanData(AppConstant.isSocialLogin,issocial);
//    }
//
//    public boolean isSocialLogin(){
//        return sharedPreferences.getBoolean(AppConstant.isSocialLogin);
//    }
//
//    public boolean getLogin(){
//        return sharedPreferences.getBoolean(AppConstant.key_login);
//    }
//
//    public void setEmail(String email){
//        sharedPreferences.setStringData(AppConstant.key_email, email);
//    }
//
//    public String getEmail(){
//        return sharedPreferences.getStringData(AppConstant.key_email);
//    }
//
//    public String getSessionName(){
//        return sharedPreferences.getStringData(AppConstant.key_session_name);
//    }
//
//    public void setSessionName(String sessionName){
//        sharedPreferences.setStringData(AppConstant.key_session_name, sessionName);
//    }

    public void clear() {
        sharedPreferences.clear();
    }
}
