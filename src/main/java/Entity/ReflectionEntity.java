package Entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Feng.Lou on 2016/10/10.
 * 反射demo
 */
public class ReflectionEntity implements Serializable {
    private String name;
    private boolean isReal;
    private int[] array;

    public ReflectionEntity() {

    }

    public ReflectionEntity(String name, boolean isReal, int[] array) {
        this.name = name;
        this.isReal = isReal;
        this.array = array;
    }

    @Override
    public String toString() {
        return "ReflectionEntity{" +
                "name='" + name + '\'' +
                ", isReal=" + isReal +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReal() {
        return isReal;
    }

    public void setReal(boolean real) {
        isReal = real;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
