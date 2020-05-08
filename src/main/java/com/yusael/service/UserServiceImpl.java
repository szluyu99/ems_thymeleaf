package com.yusael.service;

import com.yusael.dao.UserDAO;
import com.yusael.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
       user.setId(UUID.randomUUID().toString());
       userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
