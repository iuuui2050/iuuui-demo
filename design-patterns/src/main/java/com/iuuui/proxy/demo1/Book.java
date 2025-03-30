package com.iuuui.proxy.demo1;

/**
 * @author iuuui
 * @date 2024/10/27 2246
 */
public class Book implements Send{
    @Override
    public String send(String username, String address) {
        System.out.println(String.format("【书籍】发货给【[%s]，地址是：[%s]", username, address));
        return "ok";
    }
}
