package current.pool;


import java.util.concurrent.*;

/**
 * Created by Feng.Lou on 2016/10/18.
 * 线程池
 */
public class Thread2 {
    //创建固定大小的线程池
    private static ExecutorService poolFixed = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ExecutorService poolSingle = Executors.newSingleThreadExecutor();
    private ExecutorService poolCache = Executors.newCachedThreadPool();

    public static void main(String args) throws ExecutionException, InterruptedException {
        poolFixed.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

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
