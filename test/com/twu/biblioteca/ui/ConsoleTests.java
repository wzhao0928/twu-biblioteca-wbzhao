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

    private Console console;
    private ByteArrayOutputStream testOutputStream;

    @Before
    public void setUp() throws Exception {
        console = new Console();
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    @After
    public void tearDown() throws Exception {
        console = null;
        System.setOut(System.out);
    }

    @Test
    public void test_console_should_print_msg_properly() throws Exception {
        String expectedMsgOutput = "Test Message\n";
        console.printMessage(new ConsoleMessage("Test Message"));
        assertEquals(expectedMsgOutput, testOutputStream.toString());
    }

    @Test
    public void test_option_list_before_login_should_be_shown_in_main_menu() throws Exception {
        String expectedMainMenuBeforeLogin =    "Available Options:\r\n" +
                "\t[List Books] [List Movies] [Quit] [Log In]\r\n" +
                "Input Your Option > ";
        Console console = new Console();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MainMenu menu = new MainMenu();
        System.setOut(new PrintStream(outputStream));
        console.printMainMenue(menu);
        assertEquals(expectedMainMenuBeforeLogin, outputStream.toString());
        System.setOut(System.out);

    }
}
