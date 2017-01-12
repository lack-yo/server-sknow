import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/26.
 * 记录一些日常使用
 */
public class TestRecord {

    /**
     * 测试hash值的一致性
     * 覆盖equal的同时覆盖hashcode方法
     * 相等的对象具有相同的散列值
     */

    @Test
    public void testCollection() {

        Map map = new HashMap<>();

        map.put(new A(2, "fun", false), "A");

        A a = new A(2, "fun", false);

        System.out.println(map.get(a));


    }


    private class A {
        private int count;
        private String desc;
        private boolean real;

        public A() {

        }

        public A(int count, String desc, boolean real) {
            this.count = count;
            this.desc = desc;
            this.real = real;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (count != a.count) return false;
            if (real != a.real) return false;
            if (desc != null ? !desc.equals(a.desc) : a.desc != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = count;
            result = 31 * result + (desc != null ? desc.hashCode() : 0);
            result = 31 * result + (real ? 1 : 0);
            return result;
        }
    }

}
