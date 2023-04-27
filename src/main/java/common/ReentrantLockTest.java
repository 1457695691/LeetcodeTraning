package common;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/26 16:41
 */
public class ReentrantLockTest {
    private static int count;

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            // 加锁
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + count++);
            }
            // 解锁
            lock.unlock();

        });
        thread1.setName("Thread-1");
        thread1.start();


        Thread thread2 = new Thread(() -> {
            // 加锁
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + count--);
            }
            // 解锁
            lock.unlock();

        });
        thread2.setName("Thread-2");
        thread2.start();


    }
}
