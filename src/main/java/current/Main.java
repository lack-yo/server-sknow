package current;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Feng.Lou on 2017/1/19.
 * 简单锁用法，参考ArrayBlockingQueue
 */
public class Main {
    private ArrayBlockingQueue queue;

    private ReentrantLock lock = new ReentrantLock();
    private Condition isNotEmpty = lock.newCondition();
    private Condition isNotFull = lock.newCondition();
    private Object[] items;
    private int index;

    public <T> void put(T t) throws InterruptedException {

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
        while(items.length==0){
            isNotEmpty.await();
        }
        T t = (T) items[index];
        isNotFull.signal();
        lock.unlock();
        return t;
    }
}
