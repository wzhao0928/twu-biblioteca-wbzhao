package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15-4-11.
 */
public class WelcomeMessage {

    private String defaultWelcomeMessage =  "**********************************\r\n" +
                                            "*    Welcome to the Library!     *\r\n" +
                                            "**********************************";

    public String getWelcomeMessage() {
        return getDefaultWelcome();
    }

    private String getDefaultWelcome() {
        return defaultWelcomeMessage;
    }
}
