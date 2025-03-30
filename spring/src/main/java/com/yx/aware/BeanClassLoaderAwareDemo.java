package com.yx.aware;

import org.springframework.beans.factory.BeanClassLoaderAware;

/**
 * @author iuuui
 * @date 2025/03/23 1104
 */
//@Component
public class BeanClassLoaderAwareDemo implements BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.err.println("BeanClassLoaderAwareDemo");
    }
}
