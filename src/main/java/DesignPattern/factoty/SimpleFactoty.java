package DesignPattern.factoty;

/**
 * Created by Administrator on 2016/12/26.
 * 简单工厂方法的实现
 * 解开A调用B实例的硬编码耦合
 */
public class SimpleFactoty {
    public static BaseInterFace getTargetOfType(String type) {
        BaseInterFace printer = null;
        if ("mobile".equals(type)) {
            printer = new MobilePrinter();
        } else if ("computer".equals(type)) {
            printer = new ComputerPrinter();
        }
        return printer;
    }
}
