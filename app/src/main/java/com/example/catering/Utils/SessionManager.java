package com.example.catering.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created By Md.Harun or rashid on 9 th, aug,2021
 **/
public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREFER_NAME = "sessionManager";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";


    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createUserLoginSession(){
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.commit();
    }


    public void logoutUser(){
        editor.clear();
        editor.commit();
    }
    public boolean isUserLoggedIn(){
        return pref.getBoolean(IS_USER_LOGIN, false);
    }

}
