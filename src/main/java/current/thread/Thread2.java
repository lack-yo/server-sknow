package current.thread;


import java.util.concurrent.*;

/**
 * Created by Feng.Lou on 2016/10/18.
 * 线程池使用和创建
 */
public class Thread2 {
    //创建固定大小的线程池
    private static ExecutorService poolFixed = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ExecutorService poolSingle = Executors.newSingleThreadExecutor();
    private ExecutorService poolCache = Executors.newCachedThreadPool();

    public static void main(String args) {
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
        try {
            System.out.println(b.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        poolFixed.shutdown();


    }

}
