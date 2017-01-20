package reflect;


import enums.ITypeEnum;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * Created by Administrator on 2016/10/5.
 * 测试反射demo
 * 反射方法的执行，放射获取类的属性和方法
 */
public class Main {

    @Test
    public void reflect() {
        Class<?> c1 = Invoker.class;
        System.out.println(c1.getName());
        //获取成员变量
        Field[] fs = c1.getDeclaredFields();
        for (Field f : fs) {
            System.out.println(Modifier.toString(f.getModifiers()));
            System.out.println(f.getName());
            System.out.println(f.getType());
        }

        try {
            //执行方法
            Invoker i = (Invoker) c1.newInstance();
            Method mm = c1.getMethod("print", String.class, String.class);
            //对象，参数
            mm.invoke(i, new String[]{"1", "2"});
            //构造器,无参构造器和有参构造器
            Constructor con = c1.getDeclaredConstructor();
            //获取实例
            Invoker ii1 = (Invoker) con.newInstance();
            System.out.println("param:Num is " + ii1.getNum());
            Constructor con2 = c1.getDeclaredConstructor(new Class[]{String.class, int.class});
            Invoker ii = (Invoker) con2.newInstance(new Object[]{"a", 1});
            System.out.println("param:Num is " + ii.getNum());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        Method[] ms = c1.getDeclaredMethods();
//        for(Method m : ms){
//            System.out.println("method:"+m.getName());
//            if("print".equals(m.getName())){
//                m.invoke(i,"x","y");
//            }
//
//        }


    }


    public static void main(String[] args) {
        System.out.println(ITypeEnum.BORING.getDesc());
        System.out.println(ITypeEnum.SCARY.toString());
    }
}
