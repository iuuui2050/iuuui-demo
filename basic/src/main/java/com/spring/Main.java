package com.spring;

import com.base.domain.Class;
import com.base.domain.School;
import com.base.domain.Student;
import com.spring.config.BeanConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

/**
 * @author iuuui
 * @time 2024/03/16 1659
 */
public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * IOC，控制反转，解耦，不用关心对象创建及管理问题，Spring会根据你提供的配置，将对象创建出来，放在容器中，如若你需要使用某个对象，
     * 可通过 构造函数、注解注入、set方法注入 的方式得到对象，拿到对象后直接使用即可，我们在需要用到某个对象时，不再需要自己去 new 对象出来，
     * 而是通过以上三种方式，从IOC中获取对象
     */
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("domain.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        test(context);
    }

    public static void test(ApplicationContext context) {
        log.info("id >>> {}", context.getId());
        log.info("applicationName >>> {}", context.getApplicationName());
        log.info("displayName >>> {}", context.getDisplayName());
        log.info("startupDate >>> {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(context.getStartupDate()));
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        log.info("beanDefinitionNames >>> ", beanDefinitionNames);

        Student student = context.getBean(Student.class);
        log.info("{} - {} - {} - {}", student.getId(), student.getName(), student.getAge(), student.getDescribe());

        School school = context.getBean(School.class);
        log.info("{} - {} - {}", school.getId(), school.getName(), school.getDescribe());

        ApplicationContextAwareImpl impl = context.getBean(ApplicationContextAwareImpl.class);
        Class c = impl.getBean(Class.class);
        log.info("{} - {} - {}", c.getId(), c.getName(), c.getDescribe());
    }

}
