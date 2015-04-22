package com.twu.biblioteca.ui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by wbzhao on 15-4-11.
 */
public class WelcomeMessageTests {

    @Test
    public void string_content_of_default_welcome_message_test() throws Exception {
        String expectedWelcomeMessage = "";
        expectedWelcomeMessage += "**********************************\n";
        expectedWelcomeMessage += "*    Welcome to the Library!     *\n";
        expectedWelcomeMessage += "**********************************";
        assertEquals(expectedWelcomeMessage, new WelcomeMessage().getContent());
    }

}
