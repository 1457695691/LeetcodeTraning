package work.java8;

import cn.hutool.core.lang.func.VoidFunc0;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lamdba {

    @Test
    public void lambdavsanonymousclass() {

        //old
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }).start();

        //new
        new Thread(() -> System.out.println("hello2")).start();
    }


    @Test
    public void functionalInterfaces() {
        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());
        Supplier<String> stringSupplier = () -> "Ok";
        System.out.println(stringSupplier.get());


        Predicate<Integer> integerPredicate = i -> i > 0;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        assertTrue(integerPredicate.and(evenNumber).test(2));

        Consumer<String> pritln = System.out::println;
        pritln.andThen(pritln).accept("abcdefg");


    }

}
