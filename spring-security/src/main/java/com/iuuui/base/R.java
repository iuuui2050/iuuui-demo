package com.iuuui.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iuuui
 * @date 2025/03/29 1105
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {

    private int code;

    private String msg;

    private Object data;

    public static R ok() {
        return new R(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

    public static R ok(String key, Object val) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, val);
        return new R(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), map);
    }

    public static R ok(Object data) {
        return new R(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static R forbidden() {
        return new R(HttpStatus.FORBIDDEN.value(), "被禁止访问", null);
    }

    public static R forbidden(String msg) {
        return new R(HttpStatus.FORBIDDEN.value(), msg, null);
    }

    public static R error(String msg) {
        return new R(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }

}
