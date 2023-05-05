package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/28 16:43
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("application.xml");

        BeanA beanA = context.getBean(BeanA.class);

        beanA.do1();
    }
}
