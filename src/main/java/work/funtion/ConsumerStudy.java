package work.funtion;

import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;

/**
 * @author Ayuan
 * @Description: Consumer学习
 * @date 2023/4/6 09:57
 */
public class ConsumerStudy {
    public static void main(String[] args) {
        //1.Consumer<T>
        System.out.println("Consumer<T>");
        //1.1->void accept(T t)	:对给定的参数执行操作
        StringBuilder sb = new StringBuilder("Hello ");
        Consumer<StringBuilder> consumer = (str) -> str.append("Jack!");
        consumer.accept(sb);
        System.out.println(sb);    // Hello Jack!

        //1.2->default Consumer andThen(Consumer<? super T> after)：返回一个组合函数，after将会在该函数执行之后应用
        Consumer<StringBuilder> consumer1 = (str) -> str.append(" Bob!");
        consumer.andThen(consumer1).accept(sb);
        System.out.println(sb);    // Hello Jack! Bob!


        //2.BiConsumer<T,U>
        System.out.println("BiConsumer<T,U>");
        //2.1->void accept(T t, U u)
        BiConsumer<String, String> biConsumer = (a, b) -> {
            sb.append(a);
            sb.append(b);
        };
        biConsumer.accept("Hello ", "Jack!");
        System.out.println(sb);    // Hello Jack!

        //2.2->default BiConsumer<T,U> andThen(BiConsumer<? super T,? super U> after)
        BiConsumer<String, String> biConsumer1 = (a, b) -> System.out.println(a + b);
        biConsumer.andThen(biConsumer1).accept("Hello", " Jack!"); // Hello Jack!


        //3.DoubleConsumer
        System.out.println("DoubleConsumer");
        //3.1->void accept(double value)
        DoubleConsumer doubleConsumer = System.out::println;
        doubleConsumer.accept(1.3); // 1.3

        //3.2->default DoubleConsumer andThen(DoubleConsumer after)
        DoubleConsumer doubleConsumer1 = System.out::println;
        doubleConsumer.andThen(doubleConsumer1).accept(1.3);


        //4.ObjDoubleConsumer<T>
        System.out.println("ObjDoubleConsumer<T>");
        //4.1->void accept(T t, double value)
        ObjDoubleConsumer<String> doubleConsumer2 = (obj, doub)
                -> System.out.println(obj + doub);
        doubleConsumer2.accept("金额：", 222.66); // 金额：222.66

    }
}
