package design.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Ayuan
 * @Description: 实现 cglib 的工厂类
 * @date 2023/4/27 09:47
 */
public class UserLogProxy implements MethodInterceptor {

    /**
     * 生成 CGLIB 动态代理类方法
     *
     * @param target
     * @return
     */
    public Object getLogProxy(Object target) {
        // 增强器类，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类字节码对象
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(this);
        // 创建动态代理对象并返回
        return enhancer.create();
    }

    /**
     * @param o         代理对象
     * @param method      目标对象中的方法的Method实例
     * @param objects     实际参数
     * @param methodProxy   代理类对象中的方法的Method实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置输出");
        return methodProxy.invokeSuper(o, objects);
    }
}
