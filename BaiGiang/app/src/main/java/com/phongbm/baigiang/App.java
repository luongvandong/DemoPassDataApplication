package com.phongbm.baigiang;

import android.app.Application;

public class App extends Application {
    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}