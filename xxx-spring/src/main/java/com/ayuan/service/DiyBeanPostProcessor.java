package com.ayuan.service;

import com.ayuan.spring.BeanPostProcessor;
import com.ayuan.spring.Component;

@Component
public class DiyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("before userService");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("after userService");
        }
        return bean;
    }
}
