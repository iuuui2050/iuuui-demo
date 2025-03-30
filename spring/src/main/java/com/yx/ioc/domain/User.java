package com.yx.ioc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author iuuui
 * @date 2025/03/23 0950
 */
@AllArgsConstructor
@ToString
@Data
public class User {

    private Long userId;

    private String userName;

    private String remark;

}
