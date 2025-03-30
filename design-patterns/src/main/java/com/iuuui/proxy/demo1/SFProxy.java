package com.iuuui.proxy.demo1;

/**
 * @author iuuui
 * @date 2024/10/27 2308
 */
public class SFProxy implements Send {

    private Send obj;

    public SFProxy(Send obj) {
        this.obj = obj;
    }

    @Override
    public String send(String username, String address) {
        System.out.println("顺丰快递发货啦");
        String value = obj.send(username, address);
        System.out.println("快递已送达");
        return value;
    }
}
