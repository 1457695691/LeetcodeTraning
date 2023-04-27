package work.funtion;

import java.util.function.Predicate;

/**
 * @author Ayuan
 * @Description: Predicate学习
 * @date 2023/4/6 09:58
 */
public class PredicateStudy {
    public static void main(String[] args) {
        //1.Predicate<T>
        System.out.println("Predicate<T>");
        //1.1->boolean test(T t):根据给定的参数进行判断
        Predicate<Integer> predicate = number -> number != 0;
        System.out.println(predicate.test(10));    //true

        //1.2->Predicate and(Predicate<? super T> other):返回一个组合判断，将other以短路与的方式加入到函数的判断中
        predicate = predicate.and(number -> number >= 10);
        System.out.println(predicate.test(10));    //true

        //1.3->Predicate or(Predicate<? super T> other):返回一个组合判断，将other以短路或的方式加入到函数的判断中
        predicate = predicate.or(number -> number != 10);
        System.out.println(predicate.test(10));    //true

        //1.4->

    }
}
