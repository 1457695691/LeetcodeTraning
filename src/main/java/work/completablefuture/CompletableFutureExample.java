package work.completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ayuan
 * @Description: 创建和执行
 * @date 2023/5/16 10:44
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.同步方法 手动触发
        CompletableFuture<String> demo1 = new CompletableFuture<>();
        demo1.complete("success");
        System.out.println(demo1.get());

        // 创建对象的同时就标记任务完成
        CompletableFuture<String> demo2 = CompletableFuture.completedFuture("success");
        System.out.println(demo2.get());


        //2.异步方法
        CompletableFuture<String> demo3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something by thread" + Thread.currentThread().getName());
            return "success";
        });
        System.out.println(demo3.get());

        // 指定线程池执行
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture<String> demo = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something by thread" + Thread.currentThread().getName());
            return "success";
        }, executor);
        System.out.println(demo.get());

        // 不需要执行结果
        CompletableFuture.runAsync(() -> {
            System.out.println("do something by thread" + Thread.currentThread().getName());
        });


    }
}