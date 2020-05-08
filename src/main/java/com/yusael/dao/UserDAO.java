package com.yusael.dao;

import com.yusael.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    void save(User user);
    User login(@Param("username") String name, @Param("password") String password);
}
