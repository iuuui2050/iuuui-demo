package com.iuuui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iuuui.entity.SysUser;
import com.iuuui.entity.SysUserRole;
import com.iuuui.mapper.SysUserMapper;
import com.iuuui.service.SysMenuService;
import com.iuuui.service.SysUserRoleService;
import com.iuuui.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 系统 - 用户表 服务实现类
 * </p>
 *
 * @author iuuui
 * @since 2025-03-29 1205
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


}
