import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2017/2/21.
 */
public class DeadLockTest {
    public static void main(String[] args) {
        final Semaphore s1 = new Semaphore(1);
        final Semaphore s2 = new Semaphore(1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        s1.acquire();
                        System.out.println("t1:s1");
                        s2.acquire();
                        s1.release();
                        s2.release();
                        System.out.println("t1:s2release");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        s2.acquire();
                        System.out.println("t2:s2");
                        s1.acquire();
                        System.out.println("t2:s1");
                        s2.release();
                        s1.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();t2.start();
    }
}
