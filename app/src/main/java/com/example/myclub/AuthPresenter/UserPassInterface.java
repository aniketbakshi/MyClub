package com.example.myclub.AuthPresenter;

import android.view.View;

import com.example.myclub.Beans.UserPassBeans;

public interface UserPassInterface {
    void loginWithEmail(UserPassBeans beans, View v);
    boolean checkAdmin();
}
