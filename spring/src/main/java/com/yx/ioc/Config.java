package com.yx.ioc;

import com.yx.ioc.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author iuuui
 * @date 2025/03/23 1001
 */
@Configuration
public class Config {

    @Bean("user")
    public User user() {
        return new User(2L, "李四", "this is Sili");
    }

    @Bean
    @Primary
    public User user2() {
        return new User(3L, "王五", "@Primary 主要的");
    }
}
