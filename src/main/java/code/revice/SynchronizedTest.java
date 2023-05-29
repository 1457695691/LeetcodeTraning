package code.revice;

import java.util.concurrent.TimeUnit;

/**
 * @author Ayuan
 * @Description: sync
 * @date 2023/5/18 09:33
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        TicketConsumer t = new TicketConsumer(10);
        Thread my = new Thread(t, "my");
        Thread your = new Thread(t, "your");
        my.start();
        your.start();
    }
}

class TicketConsumer implements Runnable {

    private static volatile Integer ticket;


    public TicketConsumer(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "开始抢第" + ticket + "张票，对象加锁之前：" + System.identityHashCode(ticket));

            System.out.println(Thread.currentThread().getName() + "开始抢第" + ticket + "张票，成功锁到的对象：" + System.identityHashCode(ticket));
            if (ticket > 0) {
                //模拟抢票延迟
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票，票数减一");
            } else {
                return;
            }
        }
    }
}