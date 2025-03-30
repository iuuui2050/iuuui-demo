package com.yx;

import com.yx.ioc.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author iuuui
 * @date 2025/03/23 0950
 */
public class Main {

    public static void main(String[] args) {
//        createIocByXml();
        createIocToJavaConfig();
    }

    public static void createIocToJavaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.yx");
//        MyBean myBean = context.getBean(MyBean.class);
//        myBean.printBeanName();
//        User bean = context.getBean(User.class);
//        System.out.println("容器启动之后拿到的User：" +  bean);
        UserServiceImpl impl = context.getBean(UserServiceImpl.class);
        impl.print();
        context.registerShutdownHook();
    }

    public static void createIocByXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Object user = context.getBean("user");
        System.out.println(user);
    }

}
