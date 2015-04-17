package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wbzhao on 15/4/17.
 */
public class UserListService {

    private Map<String, String> userCredential;
    private List<User> userList;

    public UserListService() {
        userCredential = new HashMap<String, String>();
        userCredential.put("123-4567", "123456");
        userCredential.put("765-4321", "654321");
        userList = new ArrayList<User>();
        userList.add(new User("123-4567", "Test User 1", "testuser1@test.com", "Test Address 1", "0639129751"));
        userList.add(new User("765-4321", "Test User 2", "testuser2@test.com", "Test Address 2", "0639129751"));
    }

    public User getUserByLibNumber(String libNumber) {
        for (User user : userList) {
            if (user.getLibNumber().equals(libNumber))
                return user;
        }
        return null;
    }

    public boolean checkCredential(String[] libNumberAndPsw) {
        return libNumberAndPsw[1].equals(userCredential.get(libNumberAndPsw[0]));
    }
}
