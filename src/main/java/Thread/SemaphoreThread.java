package Thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;


/**
 * Created by Feng.Lou on 2016/11/30.
 * 获取信号量线程
 */
public class SemaphoreThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(SemaphoreThread.class);
    private Semaphore semaphore;//初始化信号量
    private String owner;//线程拥有者

    public SemaphoreThread(Semaphore semaphore, String owner) {
        this.semaphore = semaphore;
        this.owner = owner;
    }

    @Override
    public void run() {

        try {
            logger.debug("等待获取信号，" + owner);
            semaphore.acquire();
            logger.debug("执行任务，" + owner);
            sleep(1000);
            logger.debug("完成任务，" + owner);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug("释放信号，" + owner);
        semaphore.release();

    }
}
