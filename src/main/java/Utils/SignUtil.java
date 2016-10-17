package Utils;

import org.junit.Test;

import java.security.MessageDigest;
import java.util.*;

/**
 * Created by Feng.Lou on 2016/10/12.
 * 加密验签
 */
public class SignUtil {
    /**
     * 例子
     * 将参与验签参数生产一个签名，方式MD5
     */
    public static boolean getSign(Map<String,String> param){
        //剔除不参与验签字段
        if(param.get("key")!=null){
            param.remove("key");
        }
        TreeSet<String> set = new TreeSet<>();
        StringBuilder builder = new StringBuilder();
        //所有字段按字典序重排
        set.addAll(param.keySet());

        String paramSign = "";
        for(String key:set){
            if("sign".equals(key)){
                paramSign = param.get(key);
                continue;
            }
            builder.append(key).append("=").append(param.get(key)).append("&");
        }

        //去除最后一位&符号
        builder.setLength(builder.length()-1);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("sign");
        //加密key
        String secretKey = resourceBundle.getString("sign");
        String sign = MD5Util.getMD5String(builder.toString()+secretKey);
        System.out.println("sign:"+sign);
    return paramSign.equals(sign);
    }

    @Test
    public void testSign(){
        Map<String,String> param = new HashMap<>();
        param.put("sign","null");
        param.put("4key","value4");
        param.put("2key","value2");
        param.put("3key","value3");
        param.put("1key","value1");
        boolean isEq = getSign(param);
        System.out.println("sign is "+isEq);
    }

}
