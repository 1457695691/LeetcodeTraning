package com.ayuan.service;

import com.ayuan.spring.BeanPostProcessor;
import com.ayuan.spring.Component;

import java.lang.reflect.Proxy;

@Component
public class DiyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if ("loginServiceImpl".equals(beanName)) {
            System.out.println("before loginServiceImpl");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if (!"loginServiceImpl".equals(beanName)) {
            return bean;
        }
        System.out.println("after loginServiceImpl");
        //jdk动态代理实现AOP
        return Proxy.newProxyInstance(
                DiyBeanPostProcessor.class.getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("切面AOP开始");
                    return method.invoke(bean, args);
                });
    }
}
