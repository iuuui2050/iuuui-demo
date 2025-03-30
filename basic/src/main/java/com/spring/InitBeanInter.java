package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author iuuui
 * @time 2024/03/16 2230
 */
public class InitBeanInter implements InitializingBean {

    private final static Logger log = LoggerFactory.getLogger(InitializingBean.class);

    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean afterPropertiesSet");
    }
}
