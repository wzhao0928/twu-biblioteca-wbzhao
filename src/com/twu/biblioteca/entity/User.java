package com.twu.biblioteca.entity;

/**
 * Created by wbzhao on 15/4/16.
 */
public class User {

    private String libNumber;

    private String name;
    private String email;
    private String address;
    private String phone;

    public User(String libNumber, String name, String email, String address, String phone) {
        this.libNumber = libNumber;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getLibNumber() {
        return libNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

}
