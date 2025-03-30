package com.yx.ioc;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author iuuui
 * @date 2025/03/23 1120
 */
//@Component("这是bean名称")
public class MyBean implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public void printBeanName() {
        System.out.println("这是我在容器中的名称：" + beanName); // 这是我在容器中的名称：这是bean名称
    }
}
