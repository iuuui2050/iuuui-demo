package com.basic;

import com.base.domain.Student;
import sun.nio.cs.ext.IBM037;

/**
 * @author iuuui
 * @time 2024/03/21 2146
 */
public class BasicDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        classLoader();
    }

    public static void classLoader() throws ClassNotFoundException {
        // sun.misc.Launcher$AppClassLoader@b4aac2  应用程序类加载器
        System.out.println(BasicDemo.class.getClassLoader());
        // sun.misc.Launcher$ExtClassLoader@1bbe9ba 扩展类加载器
        System.out.println(BasicDemo.class.getClassLoader().getParent());
        // null 启动类加载器是由C语言实现的，无法获取
        System.out.println(BasicDemo.class.getClassLoader().getParent().getParent());

        ClassLoader loader = Student.class.getClassLoader();
        loader.loadClass("com.base.domain.Student");
    }

}
class Test {
    static {
    System.err.println("Test static execute");
    }
}
