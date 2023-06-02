package work.completablefuture;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ayuan
 * @Description: 多任务编排
 * @date 2023/6/1 11:19
 */
public class MultiTask {

    /**
     * 一元依赖: 步骤2需要依赖步骤1执行完毕才能执行，类似主线程的顺序执行
     */
    @Test
    @SneakyThrows
    public void test1() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture<String> step1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行【步骤1】");
            return "【步骤1的执行结果】";
        }, executor);

        CompletableFuture<String> step2 = step1.thenApply(result -> {
            System.out.println("上一步操作结果为：" + result);
            return "【步骤2的执行结果】";
        });
        System.out.println("步骤2的执行结果：" + step2.get());
    }

    /**
     * 二元依赖: 步骤1和2是并行的，而步骤3需要等步骤1和2执行完之后才能执行
     */
    @Test
    @SneakyThrows
    public void test2() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture<String> step1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行【步骤1】");
            return "【步骤1的执行结果】";
        }, executor);

        CompletableFuture<String> step2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行【步骤2】");
            return "【步骤2的执行结果】";
        }, executor);

        CompletableFuture<String> step3 = step1.thenCombine(step2, (result1, result2) -> {
            System.out.println("前两步操作结果分别为：" + result1 + result2);
            return "【步骤3的执行结果】";
        });

        System.out.println("步骤3的执行结果：" + step3.get());
    }


    /**
     * 多元依赖：步骤M需要依赖1-N的N个前置节点
     */
    @Test
    @SneakyThrows
    public void test3() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture<String> step1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行【步骤1】");
            return "【步骤1的执行结果】";
        }, executor);
        CompletableFuture<String> step2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行【步骤2】");
            return "【步骤2的执行结果】";
        }, executor);
        CompletableFuture<String> step3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行【步骤3】");
            return "【步骤3的执行结果】";
        }, executor);

        CompletableFuture<Void> stepM = CompletableFuture.allOf(step1, step2, step3);
        CompletableFuture<String> stepMResult = stepM.thenApply(res -> {
            // 通过join函数获取返回值
            String result1 = step1.join();
            String result2 = step2.join();
            String result3 = step3.join();

            return result1 + result2 + result3;
        });
        System.out.println("步骤M的结果：" + stepMResult.get());
    }
}
