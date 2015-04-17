package com.twu.biblioteca.repo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wbzhao on 15/4/17.
 */
public class UserListService {

    public UserListService() {
        userCredential = new HashMap<String, String>();
        userCredential.put("123-4567", "123456");
    }

    private Map<String, String> userCredential;
}
