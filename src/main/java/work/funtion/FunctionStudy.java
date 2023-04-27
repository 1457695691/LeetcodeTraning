package work.funtion;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

/**
 * @author Ayuan
 * @Description: function学习
 * @date 2023/4/4 16:55
 */
public class FunctionStudy {
    public static void main(String[] args) {
        //1.Function<T, R>
        System.out.println("Function<T, R>");
        //1.1->R apply(T t)：将此参数应用到函数中
        Function<String, String> function = a -> a + " Jack!";
        System.out.println(function.apply("Hello"));// Hello Jack!

        //1.2->Function<T, R> andThen(Function<? super R,? extends V> after)：返回一个组合函数，该函数结果应用到after函数中
        Function<String, String> function1 = a -> a + " Bob!";
        String greet = function.andThen(function1).apply("Hello");
        System.out.println(greet); // Hello Jack! Bob!

        //1.3->Function<T, R> compose(Function<? super V,? extends T> before)：返回一个组合函数，首先将入参应用到before函数，再将before函数结果应用到该函数中
        String greet2 = function.compose(function1).apply("Hello");
        System.out.println(greet2); // Hello Bob! Jack!


        //2.BiFunction<T, U, R>
        System.out.println("BiFunction<T, U, R>");
        //2.1->R apply(T t, U u)：将此参数应用到函数中
        BiFunction<String, String, String> biFunction = (a, b) -> a + b;
        System.out.println(biFunction.apply("Hello ", "Jack!")); // Hello Jack!

        //2.2->BiFunction<T,U,V> andThen(Function<? super R,? extends V> after)	:返回一个组合函数，after函数应用于该函数之后
        Function<String, String> function2 = (a) -> a + "!!!";
        System.out.println(biFunction.andThen(function2).apply("Hello", " Jack")); // Hello Jack!!!


        //3.DoubleFunction
        System.out.println("DoubleFunction");
        //3.1->R apply(T t, U u)：将此参数应用到函数中
        DoubleFunction<String> doubleFunction = doub -> "结果：" + doub;
        System.out.println(doubleFunction.apply(1.6)); // 结果：1.6


        //4.DoubleToIntFunction
        System.out.println("DoubleToIntFunction");
        //4.1->int applyAsInt(double value):根据给定的参数执行函数
        DoubleToIntFunction doubleToIntFunction = doub -> Double.valueOf(doub).intValue();
        System.out.println(doubleToIntFunction.applyAsInt(1.2)); // 1


        //5.ToDoubleBiFunction<T,U>
        //5.1->double applyAsDouble(T t, U u):根据给定的参数执行函数
        ToDoubleBiFunction<Long, Float> toDoubleBiFunction = (lon, floa) -> lon
                .doubleValue() + floa.doubleValue();
        System.out.println(toDoubleBiFunction.applyAsDouble(11L, 235.5f)); // 246.5


        //6.ToDoubleFunction
        //6.1->double applyAsDouble(T value):根据给定参数执行函数
        ToDoubleFunction<Float> toDoubleFunction = Float::doubleValue;
        System.out.println(toDoubleFunction.applyAsDouble(12315f)); // 12315.0
    }
}
