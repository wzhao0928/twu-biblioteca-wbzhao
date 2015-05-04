package com.twu.biblioteca.ui;

import com.twu.biblioteca.Service.BookService;
import com.twu.biblioteca.items.BookRepoBuilder;
import com.twu.biblioteca.items.BookRepository;
import com.twu.biblioteca.items.DefaultBookRepoBuilder;

/**
 * Created by wbzhao on 15/4/22.
 */
public class Console {

    private MessageFactory messageFactory;
    private BookService bookService;

    public Console(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    public void init() {
        BookRepoBuilder bookRepoBuilder = new DefaultBookRepoBuilder();
        BookRepository bookRepository = bookRepoBuilder.build();
        bookService = new BookService(bookRepository);
        printMessage(messageFactory.welcomeMsg());
    }

    public void run() {

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
