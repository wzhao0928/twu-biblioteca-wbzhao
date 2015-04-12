package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Book;

import java.util.List;

/**
 * Created by wbzhao on 15-4-12.
 */
public interface BookListService {
    public List<Book> getBooks();
    public String print();
    public boolean checkOutBookById(long id);
    public boolean returnBookById(long id);
}
