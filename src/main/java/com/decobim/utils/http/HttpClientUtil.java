package com.decobim.utils.http;

import com.decobim.model.http.HttpClientRequest;
import com.decobim.model.http.HttpClientResponse;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/8.
 */
public class HttpClientUtil {
    private static CloseableHttpClient client;

    public static HttpClientResponse doGet(HttpClientRequest request) {
        init();
        HttpUriRequest httpRequest = new HttpGet(request.getUrl());
        return sendRequest(httpRequest,request);
    }

    public static HttpClientResponse doPost(HttpClientRequest request){
        init();
        HttpUriRequest httpRequest = new HttpPost(request.getUrl());
        return sendRequest(httpRequest,request);
    }

    public static HttpClientResponse doPut(HttpClientRequest request){
        init();
        HttpUriRequest httpRequest = new HttpPut(request.getUrl());
        return sendRequest(httpRequest,request);
    }

    public static HttpClientResponse doDelete(HttpClientRequest request){
        init();
        HttpUriRequest httpRequest = new HttpDelete(request.getUrl());
        return sendRequest(httpRequest,request);
    }

    private static void init() {
        client = HttpClientBuilder.create().build();
        System.out.println("client初始化成功");
    }

    private static HttpClientResponse sendRequest(HttpUriRequest httpRequest, HttpClientRequest request) {
        //初始化response，用来接收返回结果
        HttpClientResponse httpClientResponse = new HttpClientResponse();
        String url = request.getUrl();
        if (request.getHeaders() != null) {
            for (String key : request.getHeaders().keySet()) {
                httpRequest.setHeader(key, request.getHeaders().get(key));
            }
        }
        if (request.getBody() != null && httpRequest instanceof HttpEntityEnclosingRequestBase) {
                ((HttpEntityEnclosingRequestBase) httpRequest).setEntity(new StringEntity(request.getBody(),"utf-8"));
        }
        try {
            HttpResponse httpResponse = client.execute(httpRequest);
            //获得状态码
            httpClientResponse.setStatusCode(String.valueOf(httpResponse.getStatusLine().getStatusCode()));
            //获得headers
            Header[] headers = httpResponse.getAllHeaders();
            Map<String,String> headerMap = new HashMap<String, String>();
            for (Header header : headers){
                headerMap.put(header.getName(),header.getValue());
            }
            httpClientResponse.setHeaders(headerMap);
            //获得body
            HttpEntity entity = httpResponse.getEntity();
            String body = EntityUtils.toString(entity,"utf-8");
            httpClientResponse.setBody(body);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return httpClientResponse;
    }

    private static void close() {
        try {
            client.close();
            System.out.println("client已关闭");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("client关闭失败");
        }
    }
}
