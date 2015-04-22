package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void test_console_should_start_properly() throws Exception {
        String expectedConsoleScreen = "";
        expectedConsoleScreen += "**********************************\n";
        expectedConsoleScreen += "*    Welcome to the Library!     *\n";
        expectedConsoleScreen += "**********************************";
        expectedConsoleScreen += "\n";
        expectedConsoleScreen += "Available Options:\n";
        expectedConsoleScreen += "\t[List Books] [List Movies] [Quit] [Log In]\n";
        expectedConsoleScreen += "Input Your Option > ";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BibliotecaApp.main(null);
        assertEquals(expectedConsoleScreen, outputStream.toString());

        outputStream.reset();
        System.setIn(new ByteArrayInputStream("List Books".getBytes()));
        String expectedBookList =   "=== BOOK LIST ===\n" +
                                    "[ID: 1] [TITLE: Test Book 1] [AUTHOR: Test Author 1] [YEAR: 2001]\n" +
                "[ID: 2] [TITLE: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\n" +
                "[ID: 3] [TITLE: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\n" +
                "[ID: 4] [TITLE: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\n" +
                "[ID: 5] [TITLE: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\n" +
                "=================\n";
        assertEquals(expectedBookList, outputStream.toString());

        System.setOut(System.out);
    }

//    @Test
//    public void test_set_up_component_should_init_the_app_and_show_welcome() throws Exception {
//
//
//    }
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
