package com.iuuui.proxy.demo2;


import java.lang.reflect.Proxy;

/**
 * @author iuuui
 * @date 2024/10/27 2310
 */
public class Main {
    public static void main(String[] args) {
        MyInvocationHandler invocationHandler = new MyInvocationHandler(new Bag());
        Object proxy = Proxy.newProxyInstance(Main.class.getClassLoader(), Bag.class.getInterfaces(), invocationHandler);
        Send send = (Send) proxy;
        send.send("小红", "广东省深圳市福田区莲花小小区6栋701");
    }
}
