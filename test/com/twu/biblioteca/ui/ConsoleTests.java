package com.twu.biblioteca.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wbzhao on 15/4/22.
 */
public class ConsoleTests {

    private ByteArrayOutputStream testOutputStream;
    private Console console;

    @Before
    public void setUp() throws Exception {
        console = new Console(new MessageFactory());
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    @After
    public void tearDown() throws Exception {
        console = null;
        testOutputStream = null;
        System.setOut(System.out);
    }

    @Test
    public void test_console_init_should_initialize_the_console_with_welcome_msg() throws Exception {
        String expectedWelcome =    "********************************\n" +
                                    "*    Welcome to Biblioteca!    *\n" +
                                    "********************************";
        console.init();
        assertEquals(expectedWelcome + "\n", testOutputStream.toString());
    }

    @Test
    public void test_console_run_should_list_all_the_books() throws Exception {
        String allBooksList =   "=== BOOK LIST ===\n" +
                                "[ID: 1] [TITLE: TestBook1] [AUTHOR: TestAuthor1] [YEAR: 2001]\n" +
                                "[ID: 2] [TITLE: TestBook2] [AUTHOR: TestAuthor2] [YEAR: 2002]\n" +
                                "[ID: 3] [TITLE: TestBook3] [AUTHOR: TestAuthor3] [YEAR: 2003]\n" +
                                "=================\n";
        console.init();
        clearConsoleScreen();
        console.run();
        assertEquals(allBooksList, testOutputStream.toString());
    }

//    @Test
//    public void test_console_run_should_start_with_proper_main_menu() throws Exception {
//        String expectedStartMainMenu =  "Available Options:\n" +
//                                        "\t[List Books] [List Movies] [Log In] [Quit]\n" +
//                                        "Input Your Option > ";
//        console.init();
//        clearConsoleScreen();
//        console.run();
//        assertEquals(expectedStartMainMenu, testOutputStream.toString());
//    }

//    @Test
//    public void test_print_msg_should_properly_print_the_message() throws Exception {
//        String expectedTestMsgString = "This is a test message.";
//        Message testMsg = new Message(expectedTestMsgString);
//        console.printMessage(testMsg);
//        assertEquals(expectedTestMsgString + "\n", testOutputStream.toString());
//    }

    private void clearConsoleScreen() {
        testOutputStream.reset();
    }
}

// TODO: console should only get data from options execution, not the strings
