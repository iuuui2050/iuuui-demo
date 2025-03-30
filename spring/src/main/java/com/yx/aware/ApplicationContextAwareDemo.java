package com.yx.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author iuuui
 * @date 2025/03/23 1055
 */
//@Component
public class ApplicationContextAwareDemo implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        /*System.out.println();
        System.out.println("-------------------- ApplicationContextAwareDemo start -------------------- ");
        System.out.println("id：" + applicationContext.getId());
        System.out.println("applicationName：" + applicationContext.getApplicationName());
        System.out.println("displayName：" + applicationContext.getDisplayName());
        System.out.println("startupDate：" + applicationContext.getStartupDate());
        System.out.println("beanDefinitionCount：" + applicationContext.getBeanDefinitionCount());
        System.out.println("beanDefinitionNames：" + Arrays.stream(applicationContext.getBeanDefinitionNames()).collect(Collectors.joining("、")));
        System.out.println("getBeansOfType：" + applicationContext.getBeansOfType(User.class));
        System.out.println("-------------------- ApplicationContextAwareDemo end -------------------- ");
        System.out.println();*/
        System.err.println("ApplicationContextAwareDemo");
    }
}
