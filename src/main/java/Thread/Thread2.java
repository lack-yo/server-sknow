package Thread;


import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Feng.Lou on 2016/10/18.
 * 线程池
 */
public class Thread2 {
    //创建固定大小的线程池
    private ExecutorService poolFixed = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ExecutorService poolSingle = Executors.newSingleThreadExecutor();
    private ExecutorService poolCache = Executors.newCachedThreadPool();

    @Test
    public void testPoolExecute() {
        poolFixed.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    /**
     * 有返回值的同步执行
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testPoolSubmit() throws ExecutionException, InterruptedException {
        Future b = poolFixed.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });
        System.out.println(b.get());
        poolFixed.shutdown();
    }

}
