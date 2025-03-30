package com.iuuui.proxy.demo2;

/**
 * @author iuuui
 * @date 2024/10/27 2306
 */
public class Bag implements Send {
    @Override
    public String send(String username, String address) {
        System.out.println(String.format("【背包】发货给【[%s]，地址是：[%s]", username, address));
        return "ok";
    }
}
