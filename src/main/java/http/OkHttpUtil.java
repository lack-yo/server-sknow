package http;

import okhttp3.*;

import java.io.IOException;

/**
 * @author loufeng
 * @date 2017/7/1 下午9:44.
 * okHttp 官方示例
 */
public class OkHttpUtil {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
