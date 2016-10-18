package Thread;

/**
 * Created by Feng.Lou on 2016/10/18.
 * 线程应用1
 * 生命周期
 */
public class Thread1 {
    private static class T1 implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<20;i++)
            System.out.println("this is Thread T1 ["+i+"] running");
        }
    }

    private static class T2 implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<20;i++)
            System.out.println("this is Thread T2 ["+i+"] running");
        }
    }
    public static void main(String[] a) throws InterruptedException {
        Thread t = new Thread(new T1());
        t.start();
        Thread t2 = new Thread(new T2());
        t2.start();
    }
}
