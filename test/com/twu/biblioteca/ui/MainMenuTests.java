package com.twu.biblioteca.ui;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by wbzhao on 15-4-12.
 */
public class MainMenuTests {

    @Test
    public void test_main_menu_should_give_option_list() throws Exception {
        MainMenu mainMenu = new MainMenu();
        String[] availableCommand = new String[]{"List Books", "Quit", "Check-out Book"};
        List<String> stringOptionList = new ArrayList<String>();
        for (Option opt : mainMenu.listOptions()) {
            stringOptionList.add(opt.toString());
        }
        for (String command: availableCommand) {
            assertTrue(stringOptionList.contains(command));
        }
    }


}
