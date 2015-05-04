package com.twu.biblioteca.ui;

import com.twu.biblioteca.items.Book;

import java.util.List;

/**
 * Created by wbzhao on 15/5/2.
 */
public class MessageFactory {

    public Message welcomeMsg() {
        return new WelcomeMessage();
    }

    public Message listItemsMsg(List<Book> books) {
        return new ListItemsMessage(books);
    }
}
