package common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Ayuan
 * @Description: ArrayBlockingQueue
 * @date 2023/4/26 16:23
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws Exception {
        // 必须设置队列的长度
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(4);

        // 生产者扔数据
        queue.add("1");
        queue.offer("2");
        queue.offer("3", 2, TimeUnit.SECONDS);
        queue.put("2");

        // 消费者取数据
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.take());
    }
}
