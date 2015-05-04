package com.twu.biblioteca.items;

import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by wbzhao on 15/5/4.
 */
public class BookRepositoryTest {

    private BookRepository bookRepository;
    private List<Book> expectedBookList;

    @Before
    public void setUp() throws Exception {
        expectedBookList = new ArrayList<Book>();
        BookBuilder builder = new BookBuilder();
        expectedBookList.add(builder.setId(1).setTitle("TestBook1").setAuthor("TestAuthor1").setYear(Year.of(2001)).build());
        expectedBookList.add(builder.setId(2).setTitle("TestBook2").setAuthor("TestAuthor2").setYear(Year.of(2002)).build());
        expectedBookList.add(builder.setId(3).setTitle("TestBook3").setAuthor("TestAuthor3").setYear(Year.of(2003)).build());
        BookRepoBuilder bookRepoBuilder = new BookRepoBuilder();
        for (Book book : expectedBookList) {
            bookRepoBuilder.addBook(book);
        }
        bookRepository = bookRepoBuilder.build();
    }

    @Test
    public void testGetAllBooks() throws Exception {
        for (Book book : expectedBookList) {
            assertTrue(bookRepository.getAllBooks().contains(book));
        }
    }
}
