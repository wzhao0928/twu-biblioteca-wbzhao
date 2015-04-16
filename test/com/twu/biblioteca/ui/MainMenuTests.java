package com.twu.biblioteca.ui;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by wbzhao on 15-4-12.
 */
public class MainMenuTests {

//    @Test
//    public void test_main_menu_should_give_option_list() throws Exception {
//        MainMenu mainMenu = new MainMenu();
//        String[] availableCommand = new String[]{"List Books", "List Movies", "Quit", "Check-out Book", "Return Book",
//                "Check-out Movie", "Return Movie"};
//        List<String> stringOptionList = new ArrayList<String>();
//        for (Option opt : mainMenu.listOptions()) {
//            stringOptionList.add(opt.toString());
//        }
//        for (String command: availableCommand) {
//            assertTrue(stringOptionList.contains(command));
//        }
//    }

    @Test
    public void test_main_menu_should_give_public_options_before_login() throws Exception {
        MainMenu mainMenu = new MainMenu();
        String[] beforeLoginOpts = new String[]{"List Books", "List Movies", "Quit", "Log in"};
        String[] loggedInOnlyOpts = new String[] {"Check-out Book", "Return Book", "Check-out Movie", "Return Movie", "Log out"};
        List<String> stringOptionList = new ArrayList<String>();
        mainMenu.setLogin(false);
        for (Option opt : mainMenu.listOptions()) {
            stringOptionList.add(opt.toString());
        }
        for (String opt : beforeLoginOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt : loggedInOnlyOpts) {
            assertFalse(stringOptionList.contains(opt));
        }
    }

    @Test
    public void test_main_menu_should_give_logged_in_options_after_login() throws Exception {
        MainMenu mainMenu = new MainMenu();
        String[] onlyBeforeLoginOpts = new String[]{"Log in"};
        String[] loggedInOpts = new String[]{"List Books", "List Movies", "Quit", "Check-out Book", "Return Book", "Check-out Movie", "Return Movie", "Log out"};
        mainMenu.setLogin(true);
        List<String> stringOptionList = new ArrayList<String>();
        for (Option opt : mainMenu.listOptions()) {
            stringOptionList.add(opt.toString());
        }
        for (String opt: loggedInOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt : onlyBeforeLoginOpts) {
            assertFalse(stringOptionList.contains(opt));
        }

    }
}
