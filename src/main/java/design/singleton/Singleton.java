package design.singleton;

import java.util.logging.Logger;

/**
 * @author Ayuan
 * 双检锁 懒汉式，实现线程安全的单例
 * 关键词：JVM指令重排、volatile、反射攻击
 */

public class Singleton {
    static Logger logger = Logger.getLogger("Singleton");
    /**
     * 这里加个volatile进行修饰,
     * 下面的 instance = new Singleton(); 这行代码在JVM中其实是分三步执行的：
     * 1、分配内存空间；
     * 2、初始化对象；
     * 3、将instance指向分配的内存地址。
     * 但JVM具有指令重排的特性，实际的执行顺序可能会是1、3、2，导致多线程情况下出问题，
     * 使用volatile修饰instance变量 可以 避免上述的指令重排
     * tips：不太理解的是 第一个线程在执行第2步之前就已经释放了锁吗？导致其它线程进入synchronized代码块
     *      执行 instance == null 的判断？
     *  回答：第一个线程在执行第2步之前就已经释放了锁吗？（没有）。如果不使用volatile修饰instance变量，
     *  那么其他线程进来的时候，看到的instance就有可能不是null的，因为已经执行了第3步，
     *  那么此时这个线程（执行 return instance;）使用的instance是一个没有初始化的instance，就会有问题。
     */
    private volatile static Singleton instance;

    private Singleton() {

    }

    private static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                    logger.info("生成结果"+instance);
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
        getInstance();
    }
}
