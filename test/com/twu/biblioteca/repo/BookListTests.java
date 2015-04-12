package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wbzhao on 15-4-12.
 */
public class BookListTests {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void pre_existing_books_should_be_get() throws Exception {
        BookListService preExistingBookListSize5 = new PreExistingBookListSize5();
        List<Book> preExisting5Books = preExistingBookListSize5.getBooks();
        Book testBook1 = new Book(1, "Test Book 1", "Test Author 1", Year.of(2001));
        Book testBook2 = new Book(2, "Test Book 2", "Test Author 2", Year.of(2002));
        Book testBook3 = new Book(3, "Test Book 3", "Test Author 3", Year.of(2003));
        Book testBook4 = new Book(4, "Test Book 4", "Test Author 4", Year.of(2004));
        Book testBook5 = new Book(5, "Test Book 5", "Test Author 5", Year.of(2005));
        Book testBook6 = new Book(6, "Test Book 6", "Test Author 6", Year.of(2006));

        assertFalse(preExisting5Books.isEmpty());
        assertEquals(5, preExisting5Books.size());
        assertTrue(preExisting5Books.contains(testBook1));
        assertTrue(preExisting5Books.contains(testBook2));
        assertTrue(preExisting5Books.contains(testBook3));
        assertTrue(preExisting5Books.contains(testBook4));
        assertTrue(preExisting5Books.contains(testBook5));
        assertFalse(preExisting5Books.contains(testBook6));
    }

    @Test
    public void test_pre_existing_book_list_should_be_printed() throws Exception {
        BookListService preExistingBookListSize5 = new PreExistingBookListSize5();
        String expectedPrint = "[ID: 1] [NAME: Test Book 1] [AUTHOR: Test Author 1] [YEAR: 2001]\r\n" +
                "[ID: 2] [NAME: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\r\n" +
                "[ID: 3] [NAME: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\r\n" +
                "[ID: 4] [NAME: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\r\n" +
                "[ID: 5] [NAME: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\r\n";
        assertEquals(expectedPrint, preExistingBookListSize5.print());
    }
}
