package com.iuuui.service.impl;

import com.iuuui.dto.LoginUser;
import com.iuuui.entity.SysUser;
import com.iuuui.service.SysUserPermissionService;
import com.iuuui.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author iuuui
 * @date 2025/03/29 1749
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserPermissionService sysUserPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser sysUser = sysUserService.lambdaQuery().eq(SysUser::getUsername, username).one();
        if (sysUser == null) {
            throw new RuntimeException("NULL");
        }
        return createUser(sysUser);
    }

    private UserDetails createUser(SysUser sysUser) {
        return new LoginUser(new Date(), sysUser, sysUserPermissionService.getPermissionByUserId(sysUser.getId()));
    }
}
