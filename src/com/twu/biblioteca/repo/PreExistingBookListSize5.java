package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Item;

import java.time.Year;
import java.util.ArrayList;

/**
 * Created by wbzhao on 15-4-12.
 */
public class PreExistingBookListSize5 extends ItemListService {

    public PreExistingBookListSize5() {
        items = new ArrayList<Item>();
        items.add(new Book(1, "Test Book 1", "Test Author 1", Year.of(2001)));
        items.add(new Book(2, "Test Book 2", "Test Author 2", Year.of(2002)));
        items.add(new Book(3, "Test Book 3", "Test Author 3", Year.of(2003)));
        items.add(new Book(4, "Test Book 4", "Test Author 4", Year.of(2004)));
        items.add(new Book(5, "Test Book 5", "Test Author 5", Year.of(2005)));
    }

}
