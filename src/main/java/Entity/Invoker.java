package Entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/5.
 */
public class Invoker implements Serializable {
    private String str;
    private int num;

    public Invoker() {
    }

    public Invoker(String str, int num) {
        this.str = str;
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void print(String a, String b) {
        System.out.println("This is a:" + a + "!And this is b:" + b);
    }

    public void print() {
        System.out.println("aaa");
    }
}
