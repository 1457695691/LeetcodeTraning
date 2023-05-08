package com.ayuan.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ayuan
 * @Description: 控制Bean是单例还是多例
 * @date 2023/5/8 15:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //只能写在类上
public @interface Scope {
    String value() default "";
}
