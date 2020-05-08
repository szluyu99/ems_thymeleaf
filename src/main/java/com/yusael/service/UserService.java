package com.yusael.service;

import com.yusael.entity.User;

public interface UserService {
    void register(User user);
    User login(String username, String password);
}
