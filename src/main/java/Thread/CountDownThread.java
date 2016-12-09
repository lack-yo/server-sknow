package Thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Feng.Lou on 2016/11/30.
 * 同步计数
 */
public class CountDownThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(CountDownThread.class);
    private CountDownLatch countDownLatch;//同步计数器初始化
    private String name;

    public CountDownThread(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            logger.debug("============等待，" + name);
            countDownLatch.await();//阻塞
            logger.debug("============执行，" + name);
            sleep(2000);
            logger.debug("============执行完毕，" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
