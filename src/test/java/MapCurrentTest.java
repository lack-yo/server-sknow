import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
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
