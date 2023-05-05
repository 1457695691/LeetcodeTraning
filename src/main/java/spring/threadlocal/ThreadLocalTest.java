package spring.threadlocal;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/28 17:31
 */
public class ThreadLocalTest {
    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.showTwoThread();
    }

    public void showTwoThread() {
        new Thread(() -> {
            threadLocal.set("Thread1");
            System.out.println("I am " + threadLocal.get());
        }).start();

        new Thread(() -> {
            threadLocal.set("Thread2");
            System.out.println("I am " + threadLocal.get());
        }).start();
    }
}
