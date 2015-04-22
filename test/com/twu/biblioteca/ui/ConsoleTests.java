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
        console = new Console();
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
    public void test_console_run_should_start_with_proper_main_menu() throws Exception {
        String expectedStartMainMenu =  "Available Options:\n" +
                                        "\t[List Books] [List Movies] [Log In] [Quit]\n" +
                                        "Input Your Option > ";
        console.init();
        clearConsoleScreen();
        console.run();
        assertEquals(expectedStartMainMenu, testOutputStream.toString());
    }

    private void clearConsoleScreen() {
        testOutputStream.reset();
    }
}
