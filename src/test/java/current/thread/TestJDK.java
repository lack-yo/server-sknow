package current.thread;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/10/20.
 * 基于本地内存的锁控制
 */
public class TestJDK {
    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

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
        Object o3 = getLockObject(id);
        System.out.println(o3.toString());
        System.out.println(o1 == o3);
    }

    private synchronized Object getLockObject(String key) {
        Object o = new Object();
        /**
         * If the specified key is not already associated
         * with a value, associate it with the given value.
         * This is equivalent to
         * <pre>
         *   if (!map.containsKey(key))
         *       return map.put(key, value);
         *   else
         *       return map.get(key);
         * </pre>
         * except that the action is performed atomically.
         *
         **/
        Object value = map.putIfAbsent(key, o);
        if (value == null) {
            value = o;
        }
        return value;
    }
}
