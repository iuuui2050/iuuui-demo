package com.iuuui.service.impl;

import com.iuuui.dto.LoginUser;
import com.iuuui.req.LoginBodyReq;
import com.iuuui.service.LoginService;
import com.iuuui.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

/**
 * @author iuuui
 * @date 2025/03/29 1219
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public Map<String, Object> login(LoginBodyReq req) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        // 调用 UserDetailServiceImpl.loadUserByUsername 方法
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        return Collections.singletonMap("token", JWTUtil.generateToken(loginUser));
    }
}
