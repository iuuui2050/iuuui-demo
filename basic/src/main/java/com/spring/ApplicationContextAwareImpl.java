package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author iuuui
 * @time 2024/03/16 2240
 */
public class ApplicationContextAwareImpl implements ApplicationContextAware {

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);
    }

}
