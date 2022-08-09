package common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ayuan
 */
public class ByteMain {
public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException{
        for (int i = 0 ;i <10 ;i++){
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }


        executorService.shutdown();
        System.out.println("Waiting...");
        boolean isTermination = executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Waiting...Done");
        if (isTermination){
            System.out.println("All Thread done");
        }
    }

}
