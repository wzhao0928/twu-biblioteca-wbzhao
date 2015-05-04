package com.twu.biblioteca.Service;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.BookBuilder;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by wbzhao on 15/5/4.
 */
public class BookServiceTest {

    private Book[] expectedBookList;
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        BookBuilder builder = new BookBuilder();
        expectedBookList = new Book[]{
                builder.setId(1).setTitle("TestBook1").setAuthor("TestAuthor1").setYear(Year.of(2001)).build(),
                builder.setId(2).setTitle("TestBook2").setAuthor("TestAuthor2").setYear(Year.of(2002)).build(),
                builder.setId(3).setTitle("TestBook3").setAuthor("TestAuthor3").setYear(Year.of(2003)).build()
        };
        bookService = new BookService();
    }

    @Test
    public void testGetAllAvailableBooks() throws Exception {
        List<Book> bookList = bookService.getAllAvailableBooks();
        for (Book book : expectedBookList) {
            assertTrue(bookList.contains(book));
        }

    }
}
