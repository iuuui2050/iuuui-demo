package com.iuuui.service;

import com.iuuui.req.LoginBodyReq;

import java.util.Map;

/**
 * @author iuuui
 * @date 2025/03/29 1218
 */
public interface LoginService {

    Map<String, Object> login(LoginBodyReq req);

}
