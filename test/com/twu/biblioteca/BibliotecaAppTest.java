package com.twu.biblioteca;


import com.twu.biblioteca.ui.Console;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void test_console_should_start_properly() throws Exception {
        String expectedConsoleScreen = "";
        expectedConsoleScreen += "**********************************\r\n";
        expectedConsoleScreen += "*    Welcome to the Library!     *\r\n";
        expectedConsoleScreen += "**********************************";
        expectedConsoleScreen += "\n";
        expectedConsoleScreen += "Available Options:\r\n";
        expectedConsoleScreen += "\t[List Books] [List Movies] [Quit] [Log In]\r\n";
        expectedConsoleScreen += "Input Your Option > ";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Console console = new Console();
        console.init();
        console.run();
        assertEquals(expectedConsoleScreen, outputStream.toString());

        System.setOut(System.out);
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
