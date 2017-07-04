package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;

/**
 * @author loufeng
 * @date 2017/7/1 下午9:33.
 * 创建信任SSL协议的connection
 */
public class HttpURLUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpURLUtil.class);

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * post方式请求服务器(https协议)
     *
     * @param url     请求地址
     * @param headers 参数
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String doRequest(String url, Map<String, String> headers, String method)
            throws NoSuchAlgorithmException, KeyManagementException,
            IOException {
        // 获取一个SSLContext实例
        SSLContext sc = SSLContext.getInstance("SSL");
        // 初始化SSLContext实例
        sc.init(null, new TrustManager[]{new TrustAnyTrustManager()},
                new java.security.SecureRandom());

        URL console = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
        conn.setRequestMethod(method);
        //不缓存
        conn.setUseCaches(false);
        conn.setSSLSocketFactory(sc.getSocketFactory());
        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
        conn.setDoInput(true);
        conn.setDoOutput(true);

        Set<String> it = headers.keySet();
        for (String key : it) {
            conn.setRequestProperty(key, headers.get(key));
        }
        conn.connect();
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            if (is != null) {
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
                is.close();
                return new String(outStream.toByteArray());
            }
        }
        logger.error("请求失败：errorCode: "+conn.getResponseCode());
        return null;
    }

}
