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
    }
    //需要传入Content-Type
    public void setHeaders() throws Exception {
        headers = new HashMap<>();
        headers.put(HttpHeadersKey.CONTENTTYPE,"application/json");
    }
    //需要传入Content-Type，Authorization
    public void setHeaders(String token) throws Exception {
        setHeaders();
        headers.put(HttpHeadersKey.AUTHORIZATION, token);
    }
    //需要传入Content-Type，Authorization，roleId
    public void setHeaders(String token,String roleId) throws Exception {
        setHeaders();
        if (token != null){
            headers.put(HttpHeadersKey.AUTHORIZATION, token);
        }
        if (roleId != null){
            headers.put(HttpHeadersKey.ROLEID,roleId);
        }
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
