package com.st.service;

import com.st.dao.UserDao;
import com.st.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iuuui
 * @time 2024/02/01 0119
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    public List<User> select() {
        return dao.select();
    }

    public void insert(User user) {
        dao.insert(user);
    }
}
