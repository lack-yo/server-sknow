package Enum;

/**
 * Created by Feng.Lou on 2016/10/19.
 * 类型枚举类
 */
public enum ITypeEnum {
    FUN("有趣",1),BORING("无聊",2),SCARY("恐惧",3);
    private String desc;
    private int code;

    ITypeEnum() {
    }

    ITypeEnum(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String toString() {
        return "ITypeEnum{" +
                "desc='" + desc + '\'' +
                ", code=" + code +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
