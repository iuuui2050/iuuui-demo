package com.iuuui.service;

import java.util.Set;

/**
 * @author iuuui
 * @date 2025/03/29 1808
 */
public interface SysUserPermissionService {

    Set<String> getPermissionByUserId(Long userId);

}
