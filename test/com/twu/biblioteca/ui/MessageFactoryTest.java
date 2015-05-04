package com.twu.biblioteca.ui;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.BookBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by wbzhao on 15/5/2.
 */
public class MessageFactoryTest {

    private MessageFactory messageFactory;
    private List<Book> books;


    @Before
    public void setUp() throws Exception {
        messageFactory = new MessageFactory();
        books = new ArrayList<Book>();
        BookBuilder builder = new BookBuilder();
        books.add(builder.setId(1).setTitle("TestBook1").setAuthor("TestAuthor1").setYear(Year.of(2001)).build());
        books.add(builder.setId(2).setTitle("TestBook2").setAuthor("TestAuthor2").setYear(Year.of(2002)).build());
        books.add(builder.setId(3).setTitle("TestBook3").setAuthor("TestAuthor3").setYear(Year.of(2003)).build());
        messageFactory = new MessageFactory();

    }

    @After
    public void tearDown() throws Exception {
        messageFactory = null;

    }

    @Test
    public void test_welcomeMsg_should_give_a_correct_welcome_message() throws Exception {
        Message welcomeMessage = messageFactory.welcomeMsg();
        String welcome = "********************************\n" +
                "*    Welcome to Biblioteca!    *\n" +
                "********************************";
        assertEquals(welcome, welcomeMessage.getContent());
    }

    @Test
    public void test_listItemsMsg_should_give_proper_book_list() throws Exception {
        String bookListString = "=== BOOK LIST ===\n" +
                "[ID: 1] [TITLE: TestBook1] [AUTHOR: TestAuthor1] [YEAR: 2001]\n" +
                "[ID: 2] [TITLE: TestBook2] [AUTHOR: TestAuthor2] [YEAR: 2002]\n" +
                "[ID: 3] [TITLE: TestBook3] [AUTHOR: TestAuthor3] [YEAR: 2003]\n" +
                "=================";
        Message bookListMsg = messageFactory.listItemsMsg(books);
        assertEquals(bookListString, bookListMsg.getContent());

    }
}
