package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

/**
 * @author iuuui
 * @time 2024/03/16 2233
 */
public class DisposableBeanInter implements DisposableBean {

    private final static Logger log = LoggerFactory.getLogger(DisposableBeanInter.class);

    public void destroy() throws Exception {
        log.info("DisposableBean  destroy");
    }
}
