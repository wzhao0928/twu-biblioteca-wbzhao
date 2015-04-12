package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbzhao on 15-4-12.
 */
public class PreExistingBookListSize5 implements BookListService {
    private List<Book> books;

    public PreExistingBookListSize5() {
        books = new ArrayList<Book>();
        books.add(new Book(1, "Test Book 1", "Test Author 1", Year.of(2001)));
        books.add(new Book(2, "Test Book 2", "Test Author 2", Year.of(2002)));
        books.add(new Book(3, "Test Book 3", "Test Author 3", Year.of(2003)));
        books.add(new Book(4, "Test Book 4", "Test Author 4", Year.of(2004)));
        books.add(new Book(5, "Test Book 5", "Test Author 5", Year.of(2005)));
    }

    public List<Book> getBooks() {
        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public String print() {
        String toPrint = "=== BOOK LIST ===\r\n";
        for (Book book : getBooks()) {
            String bookDetail = "[ID: " + book.getId() + "] " +
                    "[NAME: " + book.getName() + "] " +
                    "[AUTHOR: " + book.getAuthor() + "] " +
                    "[YEAR: " + book.getYear() + "]\r\n";
            toPrint += bookDetail;
        }
        toPrint += "=================";
//        System.out.print(toPrint);
        return toPrint;
    }

    @Override
    public boolean checkOutBookById(long id) {
        for (Book book : books) {
            if (book.getId() == id && book.getAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }
}
