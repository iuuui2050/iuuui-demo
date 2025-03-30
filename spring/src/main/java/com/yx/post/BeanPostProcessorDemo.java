package com.yx.post;

import com.yx.ioc.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author iuuui
 * @date 2025/03/23 1135
 */
//@Component
public class BeanPostProcessorDemo implements BeanPostProcessor {

    /**
     * 初始化之前的过程
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User) {
            System.out.println(String.format("postProcessBeforeInitialization： beanName {%s}    bean {%s}", beanName, bean));
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 初始化之后的过程
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User) {
            System.out.println(String.format("postProcessAfterInitialization： beanName {%s}    bean {%s}", beanName, bean));
            User user = (User) bean;
            user.setUserName("这是扩展点修改之后的名称");
            return user;
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
