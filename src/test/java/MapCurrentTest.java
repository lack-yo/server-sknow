import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 * 在这个测试中map容器在多个线程并发访问下，可能会出现链表成环而陷入死循环
 */
public class MapCurrentTest implements Runnable{
    static Map map = new HashMap<>();
    static List list = new ArrayList();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MapCurrentTest());
        Thread t2 = new Thread(new MapCurrentTest());
        t1.start();
        t2.start();
        t1.join();t2.join();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            map.put("s" + i, i);
//            list.add(i);
        }
    }
}
