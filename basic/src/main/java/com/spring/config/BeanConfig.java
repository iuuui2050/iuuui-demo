package com.spring.config;

import com.base.domain.Class;
import com.base.domain.School;
import com.base.domain.Student;
import com.spring.ApplicationContextAwareImpl;
import com.spring.HelloBeanPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author iuuui
 * @time 2024/03/20 2126
 */
@Configuration
public class BeanConfig {

    @Bean
    public School school() {
        School school = new School();
        school.setId(1L);
        school.setName("电子科技大学");
        school.setDescribe("好大学");
        return school;
    }

    @Bean
    public Class schoolClass() {
        Class schoolClass = new Class();
        schoolClass.setId(1L);
        schoolClass.setName("4年级3班");
        schoolClass.setDescribe("很优秀的班级");
        return schoolClass;
    }

    @Bean
    public Student student() {
        Student student = new Student();
        student.setId(1L);
        student.setAge(18);
        student.setName("法外狂徒张三");
        student.setDescribe("精通法律");
        return student;
    }

    @Bean
    public ApplicationContextAware applicationContextAwareImpl() {
        return new ApplicationContextAwareImpl();
    }

    @Bean
    public HelloBeanPostProcessor helloBeanPostProcessor() {
        return new HelloBeanPostProcessor();
    }

}
