package thread;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/10/20.
 */
public class TestJDK {

    @Test
    public void testMap() {
        ConcurrentHashMap synMap = new ConcurrentHashMap();
        synMap.put("key", "xx");
        Object o = synMap.putIfAbsent("key", new Object());
        System.out.println(o.toString());
    }

    @Test
    public void testLock() {
        String id = "test1";
        Object o1 = getLockObject(id);
        System.out.println(o1.toString());
        Object o2 = getLockObject("test2");
        System.out.println(o2.toString());
        System.out.println(o1 == o2);
    }

    private synchronized Object getLockObject(String key) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        if (map.contains(key)) {
            return map.get(key);
        } else {
            Object o = new Object();
            map.put(key, new Object());
            return o;
        }
    }
}
