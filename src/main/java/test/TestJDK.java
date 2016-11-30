package test;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/10/20.
 */
public class TestJDK {

 @Test
    public void testMap(){
     ConcurrentHashMap synMap = new ConcurrentHashMap();
     Object o = synMap.putIfAbsent("key",new Object());
 }


}
