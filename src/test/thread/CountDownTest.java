package thread;

import Thread.CountDownThread;

import java.util.concurrent.CountDownLatch;


/**
 * Created by Feng.Lou on 2016/11/30.
 * 测试信号量，同步阻塞
 */
public class CountDownTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new CountDownThread(countDownLatch, "A").start();
        new CountDownThread(countDownLatch, "B").start();
        new CountDownThread(countDownLatch, "C").start();
        //new CountDownThread(countDownLatch, "D").start();
        //new CountDownThread(countDownLatch, "E").start();
        //new CountDownThread(countDownLatch, "F").start();

        //for (int i = 0; i < 2; i++) {
        //    countDownLatch.countDown();
        //}
    }
}
