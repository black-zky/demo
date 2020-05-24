package com.woniu.enevt;

import com.woniu.pojo.Log;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(applicationContext==null){
            return;
        }

        SpringContextHolder.applicationContext = applicationContext;
    }

    //发布事件
    public static void publishEvent(Log log){
        applicationContext.publishEvent(new SysLogEvent(log));
    }
}
