package com.iuuui.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author iuuui
 * @date 2025/03/30 0024
 */
@Component
public class Cache {

    static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(@Qualifier("redisTemplate") RedisTemplate redisTemplate) {
        Cache.redisTemplate = redisTemplate;
    }

    public static void setForValue(String key, Object val) {
        redisTemplate.opsForValue().set(key, val);
    }

    public static void setForValue(String key, Object val, long timeout, TimeUnit unit) {
        setForValue(key, val);
        expire(key, timeout, unit);
    }

    public static Object getForValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static void delete(String key) {
        redisTemplate.delete(key);
    }

    public static boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public static void expire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }


}
