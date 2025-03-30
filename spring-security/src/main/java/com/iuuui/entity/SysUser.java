package com.iuuui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
/**
 * <p>
 * 系统 - 用户表
 * </p>
 *
 * @author iuuui
 * @since 2025-03-29 1205
 */
@Getter
@Setter
@ToString
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录账号名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private Boolean status;

    @JsonIgnore
    public boolean isAdmin() {
        return username.equals("admin");
    }
}
