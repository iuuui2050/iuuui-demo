package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author iuuui
 * @time 2024/03/20 2147
 */
@Component
public class HelloBeanPostProcessor implements BeanPostProcessor {

    private final Logger logger = LoggerFactory.getLogger(HelloBeanPostProcessor.class);

    /**
     * Bean 初始化前处理
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("BeanPostProcessor postProcessBeforeInitialization Bean初始化前处理");
        logger.info("Bean -> {}, beanName -> {}", bean, beanName);
        return bean;
    }

    /**
     * Bean 初始化后处理
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("BeanPostProcessor postProcessAfterInitialization Bean初始化前处理");
        logger.info("Bean -> {}, beanName -> {}", bean, beanName);
        return bean;
    }
}
