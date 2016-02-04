package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jian01.zhu on 2016/1/20.
 */
public final class HttpClientUtils {

    private static final Charset UTF_8 = Charset.forName("utf-8");

    private static final Integer DEFAULT_CONNECT_TIMEOUT = 5;


    /**
     * 获取HttpClient对象
     *
     * @param timeout 超时时间，单位：秒
     * @return
     */
    private static HttpClient getHttpClient(int timeout) {
        final RequestConfig requestConfig = RequestConfig.custom()
                //连接超时时间，即，连接这个地址，这个地址在timeout秒内无响应，即视为超时
                .setConnectTimeout(timeout * 1000)
                .build();
        HttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        return httpClient;
    }


    /**
     * 提交get请求
     *
     * @param url 请求URL
     * @return
     */
    public static String doGet(String url) {
        return doGet(url, DEFAULT_CONNECT_TIMEOUT);
    }


    /**
     * 提交get请求
     *
     * @param url     请求URL
     * @param timeout 超时时间，单位：秒
     * @return
     */
    public static String doGet(String url, int timeout) {
        return doRequest(new HttpGet(url), timeout);
    }


    /**
     * 提交post请求
     *
     * @param url     请求地址
     * @param content 需要提交的内容，即body(非form表单提交)
     * @return
     */
    public static String doPost(String url, String content) {
        return doPost(url, content, DEFAULT_CONNECT_TIMEOUT);
    }

    /**
     * 提交post请求
     *
     * @param url     请求地址
     * @param content 需要提交的内容，即body(非form表单提交)
     * @param timeout 超时时间，单位：秒
     * @return
     */
    public static String doPost(String url, String content, int timeout) {
        HttpPost httpPost = new HttpPost(url);
        final HttpEntity reqEntity = new StringEntity(content, ContentType.APPLICATION_JSON);
        httpPost.setEntity(reqEntity);
        return doRequest(httpPost, timeout);
    }


    /**
     * 以form表单的形式，提交post请求
     *
     * @param url             请求地址
     * @param formExcludeFile form表单的key value    (非文件)
     * @param formFile        form表单的文件key value
     * @return
     */
    public static String doPost(String url, Map<String, List<String>> formExcludeFile, Map<String, File> formFile) {

        final MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
                .setCharset(UTF_8)
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        if (formFile != null && !formFile.isEmpty()) {
            formFile.forEach((k, v) -> multipartEntityBuilder.addBinaryBody(k, v));
        }

        if (formExcludeFile != null && !formExcludeFile.isEmpty()) {
            formExcludeFile.forEach((k, v) -> v.forEach(e -> multipartEntityBuilder.addTextBody(k, e, ContentType.APPLICATION_JSON)));
        }

        final HttpEntity reqEntity = multipartEntityBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(reqEntity);

        return doRequest(httpPost, DEFAULT_CONNECT_TIMEOUT);
    }


    /**
     * 进行Http请求，并把返回值转换成utf-8字符串
     *
     * @param httpUriRequest
     * @param timeout        超时时间，单位：秒
     * @return
     */
    private static String doRequest(HttpUriRequest httpUriRequest, int timeout) {
        String resp = null;
        HttpClient httpClient = getHttpClient(timeout);
        final HttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpUriRequest);
            if (httpResponse != null && Objects.equals(httpResponse.getStatusLine().getStatusCode(), 200)) {
                HttpEntity respEntity = httpResponse.getEntity();
                resp = EntityUtils.toString(respEntity, UTF_8);
                EntityUtils.consume(respEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp;
    }
}
