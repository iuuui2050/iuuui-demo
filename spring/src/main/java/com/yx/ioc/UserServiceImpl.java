package com.yx.ioc;

import com.yx.ioc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author iuuui
 * @date 2025/03/23 1319
 */
@Component
public class UserServiceImpl {

    @Qualifier("user")
    @Autowired
    User user;

    public void print() {
        System.out.println("==================【UserServiceImpl】==================");
        System.out.println(user);
    }
}
