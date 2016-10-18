package Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Feng.Lou on 2016/10/18.
 * 线程池
 */
public class Thread2 {
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Test
    public void testPoolExecute(){
        pool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    /**
     * 有返回值的线程执行
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testPoolSubmit() throws ExecutionException, InterruptedException {
        Future b = pool.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });
        System.out.println(b.get());
    }

}
