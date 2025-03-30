package com.iuuui.controller;

import com.iuuui.base.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iuuui
 * @date 2025/03/30 1815
 */
@RestController
@RequestMapping(value = "/other")
public class OtherController {

    @PreAuthorize("hasAnyRole('ROLE_super_admin')")
    @GetMapping(value = "/superAdmin")
    public R superAdmin() {
        return R.ok("你的角色是 super_admin");
    }

    @PreAuthorize("hasAnyRole('ROLE_normal')")
    @GetMapping(value = "/normal")
    public R normal() {
        return R.ok("你的角色是 normal");
    }

}
