package com.twu.biblioteca.ui;

import org.junit.Test;

/**
 * Created by wbzhao on 15-4-12.
 */
public class MainMenuTests {

    @Test
    public void test_main_menu_should_give_public_options_before_login() throws Exception {

    }

//    @Test
//    public void test_main_menu_should_give_logged_in_options_after_login() throws Exception {
//        Console console = new Console();
//        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
//        String[] onlyBeforeLoginOpts = new String[]{"Log in"};
//        String[] loggedInOpts = new String[]{"List Books", "List Movies", "Quit", "Check-out Book", "Return Book", "Check-out Movie", "Return Movie", "Log out"};
//        console.getSession().setLoggedInUserLibNumber("123-4567");
//        List<String> stringOptionList = new ArrayList<String>();
//        for (Option opt : console.listOptions()) {
//            stringOptionList.add(opt.toString());
//        }
//        for (String opt: loggedInOpts) {
//            assertTrue(stringOptionList.contains(opt));
//        }
//        for (String opt : onlyBeforeLoginOpts) {
//            assertFalse(stringOptionList.contains(opt));
//        }
//
//    }
}
