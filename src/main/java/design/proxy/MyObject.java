package design.proxy;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/7.
 */
public class MyObject implements Serializable,MyAction{

    public MyObject() {
    }

    public void show(String msg) {
        System.out.println("show this!" + msg);
    }
}
