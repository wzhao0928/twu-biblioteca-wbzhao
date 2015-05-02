package com.twu.biblioteca.ui;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wbzhao on 15/4/24.
 */
public class WelcomeMessageTests {

    @Test
    public void test_get_content_should_give_the_correct_content_string() throws Exception {
        String expectedWelcomeString =   "********************************\n" +
                                        "*    Welcome to Biblioteca!    *\n" +
                                        "********************************";
        Message testMsg = new WelcomeMessage();
        assertEquals(expectedWelcomeString, testMsg.getContent());
    }
}
