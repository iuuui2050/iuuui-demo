package com.iuuui.service;

import com.iuuui.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 系统 - 菜单表 服务类
 * </p>
 *
 * @author iuuui
 * @since 2025-03-29 1205
 */
public interface SysMenuService extends IService<SysMenu> {

    Set<String> getPermissionByRoleId(Long roleId);

}
