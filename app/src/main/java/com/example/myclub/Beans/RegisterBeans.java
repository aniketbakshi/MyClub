package com.example.myclub.Beans;

public class RegisterBeans {
    public String fullName;
    public String mobileNo;
    public String regd;
    public UserPassBeans userPassBeans;

    public RegisterBeans() {

    }

    public RegisterBeans(String fullName, String mobileNo, String regd, UserPassBeans userPassBeans) {
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.regd = regd;
        this.userPassBeans = userPassBeans;
    }
}
