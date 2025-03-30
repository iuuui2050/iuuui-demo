package com.st.dao;

import com.st.domain.User;

import java.util.List;

/**
 * @author iuuui
 * @time 2024/01/21 1519
 */
public interface UserDao {

    List<User> select();

    void insert(User user);

}
