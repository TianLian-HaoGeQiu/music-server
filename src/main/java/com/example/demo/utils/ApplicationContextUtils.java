package com.example.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
//工具类
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    //建立一个工厂
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this. applicationContext = applicationContext;//赋值，拿到对应的ApplicationContext

    }
    //redisTemplate stringRedisTemplate  提供一些静态方法
    public static Object getBean (String name) {
        return applicationContext. getBean (name) ;
    }
}
