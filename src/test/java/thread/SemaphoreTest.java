package thread;

import Thread.SemaphoreThread;

import java.util.concurrent.Semaphore;

/**
 * Created by Feng.Lou on 2016/11/30.
 * 测试信号量，同步阻塞
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//临界区资源，表示最高支持三次并发
        SemaphoreThread s1 = new SemaphoreThread(semaphore, "Thread 1");
        SemaphoreThread s2 = new SemaphoreThread(semaphore, "Thread 2");
        SemaphoreThread s3 = new SemaphoreThread(semaphore, "Thread 3");
        SemaphoreThread s4 = new SemaphoreThread(semaphore, "Thread 4");
        SemaphoreThread s5 = new SemaphoreThread(semaphore, "Thread 5");
        SemaphoreThread s6 = new SemaphoreThread(semaphore, "Thread 6");
        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        s6.start();
    }
}
