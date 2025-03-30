package com.iuuui.utils;


import com.iuuui.cache.Cache;
import com.iuuui.dto.LoginUser;
import com.iuuui.entity.SysUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author iuuui
 * @date 2025/03/29 1844
 */
public class JWTUtil {

    private static final String SECRET_KEY = "bc3a8538882641b3a3f092c20cf59432";

    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    private static final long TIME_OUT = 30 * 60 * 1000L;

    private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    private static final String PRE_FIX = "user-token:";

    public static final String HEADER = "Authorization";

    public static String genRedisKey(LoginUser loginUser) {
        return PRE_FIX + loginUser.getSysUser().getId();
    }
    public static String genRedisKey(Long userId) {
        return PRE_FIX + userId;
    }

    public static String generateToken(LoginUser loginUser) {
        SysUser sysUser = loginUser.getSysUser();
        Cache.setForValue(genRedisKey(loginUser), loginUser, TIME_OUT, TIME_UNIT);
        return Jwts.builder().subject(sysUser.getId().toString()).signWith(KEY).id(UUID.randomUUID().toString()).compact();
    }

    public static String parseSubject(String token) {
        return Jwts.parser().verifyWith(KEY).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public static void logout(LoginUser loginUser) {
        Cache.delete(genRedisKey(loginUser));
    }

    public static void refresh(LoginUser loginUser) {
        Cache.expire(genRedisKey(loginUser), TIME_OUT, TIME_UNIT);
    }

    public static LoginUser parseLoginUser(String token) {
        String subject = parseSubject(token);
        return JacksonUtil.convertValue(Cache.getForValue(genRedisKey(Long.valueOf(subject))), LoginUser.class);
    }

}
