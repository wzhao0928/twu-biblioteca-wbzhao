package com.twu.biblioteca.Service;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.BookRepository;

import java.util.List;

/**
 * Created by wbzhao on 15/5/4.
 */
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllAvailableBooks() {
        return bookRepository.getAllBooks();
    }
}
