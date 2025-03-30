package com.iuuui.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author iuuui
 * @date 2025/03/29 1217
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBodyReq {

    private String username;

    private String password;

}
