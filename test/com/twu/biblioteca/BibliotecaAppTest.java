package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private ByteArrayOutputStream testOutputStream;

    private String expectedScreenOnAppStart =   "********************************\n" +
                                                "*    Welcome to Biblioteca!    *\n" +
                                                "********************************\n" +
                                                "\n" +
                                                "=== BOOK LIST ===\n" +
                                                "[ID: 1] [TITLE: TestBook1] [AUTHOR: TestAuthor1] [YEAR: 2001]\n" +
                                                "[ID: 2] [TITLE: TestBook2] [AUTHOR: TestAuthor2] [YEAR: 2002]\n" +
                                                "[ID: 3] [TITLE: TestBook3] [AUTHOR: TestAuthor3] [YEAR: 2003]\n" +
                                                "=================\n";

    @Before
    public void setUp() throws Exception {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    @After
    public void tearDown() throws Exception {
        testOutputStream = null;
        System.setOut(System.out);
    }

    @Test
    public void test_app_should_work_properly() throws Exception {
        BibliotecaApp.main(null);
        assertEquals(expectedScreenOnAppStart, testOutputStream.toString());
    }

    private void getInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}
/*  TODO:
        1. Re-TDD & Functional test & Commits for refactor
        2. SysIn & SysOut should be extracted to an Object
        3. UI Templates (Design Pattern)
        4. Console & Session
        5. Options & Executor (Design Pattern)
        6. BeanBuilder
        7. Generic for Books and Movies
        8. Repository to hold context


        S.P. README & LICENSE
* */
