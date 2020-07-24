package com.heima.mapper;

import com.heima.dao.User;

import java.util.List;

public interface UserDao {
     //@Select("select * from userhma")
     List<User> findAll();
     void saveUser(User user);
     void updateUser(User user);
     List<User> selectByName(String name);
}
