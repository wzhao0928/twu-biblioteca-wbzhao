package com.twu.biblioteca.ui;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wbzhao on 15/4/22.
 */
public class ConsoleMessageTests {
    @Test
    public void test_console_message_should_be_properly_constructed_and_read() throws Exception {
        String testMsgString = "Test String";
        ConsoleMessage testConsoleMsg = new ConsoleMessage("Test String");
        assertEquals(testMsgString, testConsoleMsg.getContent());
    }
}
