package com.twu.biblioteca.authentication;

/**
 * Created by wbzhao on 15/4/17.
 */
public class Session {

    private String loggedInUserLibNumber = "";

    public boolean isLoggedIn() {
        return !loggedInUserLibNumber.isEmpty();
    }

    public String getLoggedInUserLibNumber() {
        return loggedInUserLibNumber;
    }

    public void setLoggedInUserLibNumber(String loggedInUserLibNumber) {
        this.loggedInUserLibNumber = loggedInUserLibNumber;
    }

}
