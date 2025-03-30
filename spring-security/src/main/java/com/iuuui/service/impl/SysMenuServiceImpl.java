package com.iuuui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iuuui.entity.SysMenu;
import com.iuuui.entity.SysRoleMenu;
import com.iuuui.mapper.SysMenuMapper;
import com.iuuui.service.SysMenuService;
import com.iuuui.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统 - 菜单表 服务实现类
 * </p>
 *
 * @author iuuui
 * @since 2025-03-29 1205
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    SysRoleMenuService sysRoleMenuService;

    @Override
    public Set<String> getPermissionByRoleId(Long roleId) {
        if (roleId == null) return new HashSet<>();
        List<Long> menuIds = sysRoleMenuService.lambdaQuery().eq(SysRoleMenu::getRoleId, roleId).list().stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        return super.lambdaQuery().in(SysMenu::getId, menuIds).list().stream().map(SysMenu::getCode).collect(Collectors.toSet());
    }

}
