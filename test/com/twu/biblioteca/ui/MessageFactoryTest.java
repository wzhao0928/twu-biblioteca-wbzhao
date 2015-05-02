package com.twu.biblioteca.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by wbzhao on 15/5/2.
 */
public class MessageFactoryTest {

    private MessageFactory messageFactory;

    @Before
    public void setUp() throws Exception {
        messageFactory = new MessageFactory();

    }

    @After
    public void tearDown() throws Exception {
        messageFactory = null;

    }

    @Test
    public void test_welcomeMsg_should_give_a_correct_welcome_message() throws Exception {
        Message welcomeMessage = messageFactory.welcomeMsg();
        String welcome = "********************************\n" +
                "*    Welcome to Biblioteca!    *\n" +
                "********************************";
        assertEquals(welcome, welcomeMessage.getContent());
    }
}
