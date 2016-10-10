package Utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by Feng.Lou on 2016/10/10.
 * 介绍一些常用的http请求方式
 * get\post
 */
public class HttpUtils {
    private static String DEFAULTENCODING = "UTF-8";

    /**
     * 该方法用来提供基本的get请求
     * @param url 请求地址
     * @param params 请求参数
     * @return 返回参数以JSONObject形式
     */
    public static JSONObject doGet(String url , Map<String,String> params){
        JSONObject json = new JSONObject();
        HttpClient client = null;
        HttpGet get = null;
        try{
            StringBuilder builder = new StringBuilder();
            builder.append("?");
            for(String key : params.keySet()){
                builder.append(key).append("=").append(params.get(key)).append("&");
            }
            url += builder.toString();
            get = new HttpGet(url);
            client = new DefaultHttpClient();
            HttpResponse response = client.execute(get);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                json = JSONObject.parseObject(EntityUtils.toString(entity, Charset.forName(DEFAULTENCODING)));
                //释放io资源
                EntityUtils.consume(entity);
            }
        }catch(Exception e){
            System.out.println("[error]:"+e);
        }finally{
            if(client != null)
            //释放连接资源
            client.getConnectionManager().closeExpiredConnections();
        }
        return json;
    }

    public static JSONObject doPost(String url,Map<String,String> map){
        JSONObject json = new JSONObject();
        HttpClient client = null;
        HttpPost post = null;
        try{
            StringBuilder builder = new StringBuilder();
            builder.append("?");
            for(String key : map.keySet()){
                builder.append(key).append("=").append(map.get(key)).append("&");
            }
            url += builder.toString();
            client = new DefaultHttpClient();
            post = new HttpPost(url);

            HttpResponse result = client.execute(post);
            if(result.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = result.getEntity();
                json = JSONObject.parseObject(EntityUtils.toString(entity, Charset.forName(DEFAULTENCODING)));
                //释放io资源
                EntityUtils.consume(entity);
            }

        }catch(Exception e){
            System.out.println("[error]："+e);
        }finally{
            //释放资源
            if(client != null)
                client.getConnectionManager().closeExpiredConnections();
        }
        return json;
    }

}
