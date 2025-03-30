package com.iuuui.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author iuuui
 * @date 2024/10/27 2313
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object who;

    public MyInvocationHandler(Object who) {
        this.who = who;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("顺丰快递发货啦-----------------------------");
        Object val = method.invoke(who, args);
        System.out.println("快递已送达--------------------------");
        return val;
    }
}
