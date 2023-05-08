package com.ayuan.spring;

/**
 * @author Ayuan
 * @Description: Bean定义
 * @date 2023/5/8 15:52
 */
public class BeanDefinition {

    //类型
    private Class type;
    //作用域
    private String scope;


    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
