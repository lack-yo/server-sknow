package DesignPattern;

/**
 * Created by Administrator on 2016/12/25.
 * 单例模式
 * 节省内存开销，对实例只会初始化一个唯一的指向
 * 不对外公开构造器
 */
public class SingleOO {
    private SingleOO oo = null;

    private SingleOO(){

    }

    public SingleOO getInstance(){
        if(oo == null) {
            oo = new SingleOO();
        }
        return oo;
    }
}
