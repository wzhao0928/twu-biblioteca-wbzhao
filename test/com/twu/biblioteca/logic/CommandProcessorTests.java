package com.twu.biblioteca.logic;

import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.ui.Option;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandProcessorTests {

    @Test
    public void test_command_processor_should_response_LIST_BOOKS() throws Exception {
        String expectedPrint = "[ID: 1] [NAME: Test Book 1] [AUTHOR: Test Author 1] [YEAR: 2001]\r\n" +
                "[ID: 2] [NAME: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\r\n" +
                "[ID: 3] [NAME: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\r\n" +
                "[ID: 4] [NAME: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\r\n" +
                "[ID: 5] [NAME: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\r\n";
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5());
        assertEquals(expectedPrint, processor.response(Option.LIST_BOOKS));
        assertEquals("Select a valid option!", processor.response(Option.INVALID));
        assertEquals("", processor.response(Option.QUIT));
    }
}
