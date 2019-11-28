package com.example.myclub.Beans;

import java.util.ArrayList;

public class RegisterBeans {
    public String fullName;
    public String mobileNo;
    public String regd;
    public UserPassBeans userPassBeans;
    public ArrayList<String> clubs;

    public RegisterBeans() {
        clubs = new ArrayList<>();
    }

    public RegisterBeans(String fullName, String mobileNo, String regd, UserPassBeans userPassBeans) {
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.regd = regd;
        this.userPassBeans = userPassBeans;
        this.clubs = new ArrayList<>();
    }
}
