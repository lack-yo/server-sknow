package Thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Feng.Lou on 2016/11/30.
 * 同步计数
 */
public class CountDownThread extends Thread{
    private CountDownLatch countDownLatch;//同步计数器初始化
    private String name;

    public CountDownThread(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("============执行，"+name);
            countDownLatch.await();
            sleep(1000);
            System.out.println("============执行完毕，"+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
