package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15/4/22.
 */
public class Console {
    public void init() {
        System.out.println("********************************\n" +
                "*    Welcome to Biblioteca!    *\n" +
                "********************************");
    }

    public void run() {
        System.out.print("Available Options:\n" +
                "\t[List Books] [List Movies] [Log In] [Quit]\n" +
                "Input Your Option > ");
    }
}
