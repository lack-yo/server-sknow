package thread;

import Thread.CountDownThread;

import java.util.concurrent.CountDownLatch;


/**
 * Created by Feng.Lou on 2016/11/30.
 * 测试信号量，同步阻塞
 * http://www.codeceo.com/article/java-synchronizer.html
 */
public class CountDownTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new CountDownThread(countDownLatch, "A").start();
        new CountDownThread(countDownLatch, "B").start();
        new CountDownThread(countDownLatch, "C").start();
        new CountDownThread(countDownLatch, "D").start();
        try{
            System.out.println("主线程执行准备任务");
            Thread.sleep(1000);
            System.out.println("主线程执行完毕");
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }

    }
}
