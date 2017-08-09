package com.decobim.model.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/8.
 */
public class HttpClientRequest {
    private String url;
    private Map<String,String> headers;
    private String body;

    public HttpClientRequest() {
        headers = new HashMap<>();
        headers.put("Content-Type","application/json");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HttpClientRequest{" +
                "url='" + url + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
}
