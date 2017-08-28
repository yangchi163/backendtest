package com.decobim.services.main;

import com.decobim.model.http.HttpClientRequest;
import com.decobim.model.url.UrlHost;
import com.decobim.model.url.UrlSchema;
import com.google.gson.Gson;
import org.apache.http.client.utils.URIBuilder;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/8.
 */
public class Base {
    public URIBuilder uriBuilder;
    public Gson gson;
    public HttpClientRequest request;
    public Map bodyMap;

    public Base() {
        uriBuilder = new URIBuilder()
                .setScheme(UrlSchema.schema())
                .setHost(UrlHost.host());
        gson = new Gson();
        request = new HttpClientRequest();
        bodyMap = new HashMap();
    }

}
