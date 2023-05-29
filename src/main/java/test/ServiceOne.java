package test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/5/19 13:01
 */
@Service
public class ServiceOne {


    // 设置一把可重入的公平锁
    private final Lock lock = new ReentrantLock(true);

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, noRollbackFor = Exception.class, rollbackFor = Exception.class)
    public void func(long itemId, long userId) {
        lock.lock();
        // 执行数据库操作——查询商品库存数量
        // 如果 库存数量 满足要求 执行数据库操作——减少库存数量——模拟卖出货物操作
        lock.unlock();
    }
}