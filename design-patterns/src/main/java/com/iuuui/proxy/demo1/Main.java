package com.iuuui.proxy.demo1;

/**
 * @author iuuui
 * @date 2024/10/27 2310
 */
public class Main {
    public static void main(String[] args) {
        SFProxy proxy = new SFProxy(new Bag());
        proxy.send("小明", "广东省珠海市香洲区吉大街道24号");

        proxy = new SFProxy(new Book());
        proxy.send("小红", "广东省珠海市斗门区24号");
    }
}
