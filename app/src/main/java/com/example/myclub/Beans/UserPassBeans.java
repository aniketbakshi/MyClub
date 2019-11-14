package com.example.myclub.Beans;

public class UserPassBeans {
    private String uname;
    private String pass;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserPassBeans(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
    }
}
