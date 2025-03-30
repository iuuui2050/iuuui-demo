package com.iuuui.controller;

import com.iuuui.base.R;
import com.iuuui.entity.SysUser;
import com.iuuui.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iuuui
 * @date 2025/03/29 1210
 */
@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @PreAuthorize("hasAuthority('user:select')")
    @GetMapping(value = "/list")
    public R list() {
        return R.ok(sysUserService.list());
    }

    @PreAuthorize("hasAuthority('user:status:update')")
    @GetMapping(value = "/disable")
    public R disable(Long id) {
        sysUserService.lambdaUpdate().eq(SysUser::getId, id).set(SysUser::getStatus, false).update();
        return R.ok();
    }

    @PreAuthorize("hasAuthority('user:status:update')")
    @GetMapping(value = "/enable")
    public R enable(Long id) {
        sysUserService.lambdaUpdate().eq(SysUser::getId, id).set(SysUser::getStatus, true);
        return R.ok();
    }

}
