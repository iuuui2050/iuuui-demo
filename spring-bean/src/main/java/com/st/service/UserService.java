package com.st.service;

import com.st.domain.User;

import java.util.List;

/**
 * @author iuuui
 * @time 2024/02/01 0119
 */
public interface UserService {

    List<User> select();

    void insert(User user);

}
