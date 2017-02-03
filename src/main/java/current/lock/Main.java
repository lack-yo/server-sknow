package current.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Feng.Lou on 2017/1/19.
 * 简单重入锁用法，参考ArrayBlockingQueue
 */
public class Main {
    //公平等待队列，资源数10
    private ArrayBlockingQueue queue = new ArrayBlockingQueue(10, true);

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition isNotEmpty = lock.newCondition();
    private Condition isNotFull = lock.newCondition();
    private Object[] items = new Object[10];
    private int index;

    public <T> void put(T t) throws InterruptedException {
        //可被中断的锁
        lock.lockInterruptibly();
        while (items.length == 1) {
            isNotFull.await();
        }
        items[0] = t;
        index++;
        isNotEmpty.signal();
        lock.unlock();

    }

    public <T> T take() throws InterruptedException {
        lock.lockInterruptibly();
        while (items.length == 0) {
            isNotEmpty.await();
        }
        T t = (T) items[index];
        isNotFull.signal();
        lock.unlock();
        return t;
    }
}
