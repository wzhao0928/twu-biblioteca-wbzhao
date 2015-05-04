package com.twu.biblioteca.ui;

import com.twu.biblioteca.items.Book;

import java.util.List;

/**
 * Created by wbzhao on 15/5/2.
 */
public class ListItemsMessage extends Message {
    public ListItemsMessage(List<Book> books) {
        super();
        String itemList = "=== BOOK LIST ===\n";
        for (Book book : books) {
            itemList += book.toString() + "\n";
        }
        itemList += "=================";
        this.setContent(itemList);
    }

}
