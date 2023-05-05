package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/28 16:43
 */
public class LogUtil {
    private void before(JoinPoint joinPoint) {
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        //获取参数信息
        Object[] args = joinPoint.getArgs();
        System.out.println("log---" + signature.getName() + "I am before");
    }

    private void after(JoinPoint joinPoint) {
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        //获取参数信息
        Object[] args = joinPoint.getArgs();
        System.out.println("log---" + signature.getName() + "I am before");
    }
}
