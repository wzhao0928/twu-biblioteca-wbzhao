package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15/4/22.
 */
public class Console {

    private MessageFactory messageFactory;

    public Console(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    public void init() {
        printMessage(messageFactory.welcomeMsg());
    }

    public void run() {
//        printMessage(new MainMenu("Available Options:\n" +
//                "\t[List Books] [List Movies] [Log In] [Quit]\n"));
    }

    public void printMessage(Message msg) {
        System.out.println(msg.getContent());
    }

    public MessageFactory getMessageFactory() {
        return messageFactory;
    }

    public void setMessageFactory(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    private void printMainMenuBeforeLogin(MainMenuBeforeLogin mainMenuBeforeLogin) {
        System.out.print(mainMenuBeforeLogin.getMainMenuStringBeforeLogin());
    }
}
