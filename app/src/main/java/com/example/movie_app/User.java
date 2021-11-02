package com.example.movie_app;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private String username;
    private String password;
    private String email;

    private SharedPreferences sharedPreferences;
    private static final String PREFERENCES_PACKAGE_NAME="com.example.movie_app";
    private static final String USERNAME_KEY="username";
    private static final String PASSWORD_KEY="password";
    private static final String REMEMBERME_KEY="rememberMe";

    // konstruktorius skirtas naujo vartotojo registracijai
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // konstruktorius skirtas esamo vartotojo prisijiungimui
    public User(Context context){
        this.sharedPreferences= context.getSharedPreferences(User.PREFERENCES_PACKAGE_NAME,
                Context.MODE_PRIVATE);
    }

    public String getUsernameForLogin() {
        return this.sharedPreferences.getString(USERNAME_KEY, "");
    }

    public void setUsernameForLogin(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY, username).commit();
    }

    public String getPasswordForLogin() {
        return this.sharedPreferences.getString(PASSWORD_KEY, "");
    }

    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY, password).commit();
    }

    public boolean isRemembeedForLogin(){
        return this.sharedPreferences.getBoolean(REMEMBERME_KEY, false);
    }

    public void setRemembermeKeyForLogin(boolean remembermeKey){
        this.sharedPreferences.edit().putBoolean(REMEMBERME_KEY, remembermeKey).commit();
    }

    public String getUsernameForRegistration() {
        return username;
    }

    public void setUsernameForRegistration(String username) {
        this.username = username;
    }
    public String getPasswordForRegistration() {
        return password;
    }

    public void setPasswordForRegistration(String password) {
        this.password = password;
    }

    public String getEmailForRegistration() {
        return email;
    }

    public void setEmailForRegistration(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
