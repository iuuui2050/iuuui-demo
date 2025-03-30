package com.iuuui.controller;

import com.iuuui.base.R;
import com.iuuui.dto.LoginUser;
import com.iuuui.req.LoginBodyReq;
import com.iuuui.service.LoginService;
import com.iuuui.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author iuuui
 * @date 2025/03/29 1216
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login")
    public R login(@RequestBody LoginBodyReq req) {
        Map<String, Object> map = loginService.login(req);
        return R.ok(map);
    }

    @PostMapping(value = "/logout")
    public R logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        JWTUtil.logout(loginUser);
        return R.ok();
    }

}
