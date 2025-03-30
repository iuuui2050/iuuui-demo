package com.yx.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author iuuui
 * @date 2025/03/23 1110
 */
//@Component("这是我的Bean名称")
public class BeanNameAwareDemo implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.err.println(s);
    }
}
