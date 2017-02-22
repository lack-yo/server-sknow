/**
 * Created by Administrator on 2017/2/22.
 * 该测试对String、StringBuffer、StringBuilder做一个对比测试
 * StringBuilder>StringBuffer>String
 * 定义String是一个常量，每次变更需要创建新的对象，而StringBuilder与StringBuffer是变量
 * 另外，StringBuffer是线程安全的，因此StringBuilder效率更高
 */
public class StringTest
{
    public static void main(String[] args) {
        String s1 = "0";
        StringBuffer s2 = new StringBuffer("0");
        StringBuilder s3 = new StringBuilder("0");
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            s1 = s1 + i;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("String: "+(time2-time1)+"ms");
        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            s2 = s2.append(i);
        }
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuffer: "+(time4-time3)+"ms");
        long time5 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            s3 = s3.append(i);
        }
        long time6 = System.currentTimeMillis();
        System.out.println("StringBuilder: "+(time6-time5)+"ms");
    }
}
