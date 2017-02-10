package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Feng.Lou on 2017/2/10.
 * 动态代理类
 */
public class MyProxy implements InvocationHandler {

    private Object target;

    public Object getProxy(Object obTarget){
        this.target = obTarget;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
