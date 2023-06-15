package work.completablefuture;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/6/8 15:10
 */
public class CyclicBarrierTest {
    private final static Random random = new Random();

    // 订单队列
    private Queue<Integer> pos = new ArrayDeque<>();
    // 派送单队列
    private Queue<Integer> dos = new ArrayDeque<>();

    public int getPOrder() {
        return random.nextInt();
    }

    public int getDOrder() {
        return random.nextInt();
    }

    private boolean diff(int p, int d) {
        return p == d;
    }

    public void check() {
        int p = pos.poll();
        int d = dos.poll();
        boolean diff = this.diff(p, d);
        System.out.println("校验结果:" + diff);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        CyclicBarrierTest test = new CyclicBarrierTest();
//        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future1 = CompletableFuture
                .runAsync(() -> {
                    for (int i = 0; i < 1000000; i++) { // 添加多个随机数到队列
                        test.pos.add(test.getPOrder());
                    }
                });

        CompletableFuture<Void> future2 = CompletableFuture
                .runAsync(() -> {
                    for (int i = 0; i < 1000000; i++) { // 添加多个随机数到队列
                        test.dos.add(test.getDOrder());
                    }
                });

        CompletableFuture<Void> stepM = CompletableFuture.allOf(future1, future2);

        CompletableFuture<Void> voidCompletableFuture = stepM.thenApply(result ->
        {
            while (!test.pos.isEmpty()) {
                test.check();
            }
            return result;
        });
        voidCompletableFuture.get();
//        executor.shutdown();
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
    }

}
