package com.twu.biblioteca.ui;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandLineTests {
    @Test
    public void test_command_line_should_return_option_according_to_input() throws Exception {
        CommandLine commandLine = new CommandLine();
        System.setIn(new ByteArrayInputStream("List Books".getBytes()));
        assertEquals(Option.LIST_BOOKS, commandLine.readCommand());
        System.setIn(new ByteArrayInputStream("Quit".getBytes()));
        assertEquals(Option.QUIT, commandLine.readCommand());
        System.setIn(new ByteArrayInputStream("Check-out Book".getBytes()));
        assertEquals(Option.CHECKOUT, commandLine.readCommand());
        System.setIn(System.in);
    }
}
