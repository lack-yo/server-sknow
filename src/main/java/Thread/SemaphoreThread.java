package Thread;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;


/**
 * Created by Feng.Lou on 2016/11/30.
 * 获取信号量线程
 */
public class SemaphoreThread extends Thread {
    private static final Logger logger = LogManager.getLogger(SemaphoreThread.class);
    private Semaphore semaphore;//初始化信号量
    private String owner;//线程拥有者

    public SemaphoreThread(Semaphore semaphore, String owner) {
        this.semaphore = semaphore;
        this.owner = owner;
    }

    @Override
    public void run() {

        try {
            System.out.println("等待获取信号，" + owner);
            semaphore.acquire();
            System.out.println("执行任务，" + owner);
            sleep(1000);
            System.out.println("完成任务，" + owner);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("释放信号，" + owner);
        semaphore.release();

    }
}
