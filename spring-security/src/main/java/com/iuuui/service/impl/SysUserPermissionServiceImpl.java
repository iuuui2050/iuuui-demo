package com.iuuui.service.impl;

import com.iuuui.entity.SysRole;
import com.iuuui.entity.SysUser;
import com.iuuui.entity.SysUserRole;
import com.iuuui.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author iuuui
 * @date 2025/03/29 1808
 */
@Service
public class SysUserPermissionServiceImpl implements SysUserPermissionService {

    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysRoleService sysRoleService;

    @Override
    public Set<String> getPermissionByUserId(Long userId) {
        Set<String> permissions = new HashSet<>();
        SysUser sysUser = sysUserService.getById(userId);
        if (sysUser.isAdmin()) {
            List<SysUserRole> sysUserRoles = sysUserRoleService.list();
            setRoleCode(permissions, sysUserRoles);
        } else {
            List<SysUserRole> sysUserRoles = sysUserRoleService.lambdaQuery().eq(SysUserRole::getUserId, userId).list();
            setRoleCode(permissions, sysUserRoles);
        }
        return permissions;
    }

    private void setRoleCode(Set<String> permissions, List<SysUserRole> sysUserRoles) {
        List<SysRole> sysRoles = sysRoleService.lambdaQuery().in(SysRole::getId, sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList())).list();
        permissions.addAll(sysRoles.stream().map(sysRole -> String.format("ROLE_%s", sysRole.getCode())).collect(Collectors.toList()));
        for (SysUserRole sysUserRole : sysUserRoles) {
            permissions.addAll(sysMenuService.getPermissionByRoleId(sysUserRole.getRoleId()));
        }
    }

}
