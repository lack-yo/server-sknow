package Entity;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/10/5.
 * 测试反射demo
 */
public class Main {

    @Test
    public void reflect() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> c1 = Class.forName("Invoker");
        System.out.println(c1.getName());
        //获取成员变量
        Field[] fs = c1.getDeclaredFields();
        for(Field f : fs){
            System.out.println(f.getName());
            System.out.println(f.getType());
            System.out.println(f.getModifiers());
        }
        //执行方法
        Invoker i = (Invoker)c1.newInstance();
        Method[] ms = c1.getDeclaredMethods();
        for(Method m : ms){
            System.out.println("method:"+m.getName());
            if("print".equals(m.getName()))
            m.invoke(i,"x","y");

        }

        //构造器
        Constructor con = c1.getDeclaredConstructor();
        Invoker ii1 = (Invoker) con.newInstance();
        System.out.println("param:Num is "+ii1.getNum());
        Constructor con2 = c1.getDeclaredConstructor(new Class[]{String.class,int.class});
        Invoker ii = (Invoker) con2.newInstance(new Object[]{"a", 1});
        System.out.println("param:Num is "+ii.getNum());

    }
}
