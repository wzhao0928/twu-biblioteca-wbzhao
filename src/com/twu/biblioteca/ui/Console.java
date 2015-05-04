package com.twu.biblioteca.ui;

import com.twu.biblioteca.Service.BookService;

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
        BookService bookService = new BookService();
        printMessage(messageFactory.listItemsMsg(bookService.getAllAvailableBooks()));
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

}
