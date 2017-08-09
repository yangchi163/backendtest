package com.decobim.services.main.identity;

import com.decobim.model.User;
import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.url.urlPath.Identity;
import com.decobim.services.main.Base;
import com.decobim.utils.http.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/8.
 */
public class Registry extends Base {
    public Registry() {
    }
    public HttpClientResponse registry(User user) throws Exception {
        String url = uriBuilder
                .setPath(Identity.registry())
                .build()
                .toString();
        bodyMap.put("mobile",user.getName());
        bodyMap.put("password",user.getUserPwd());
        String body = gson.toJson(bodyMap);
        request.setUrl(url);
        request.setBody(body);
        return HttpClientUtil.doPost(request);
    }

    public HttpClientResponse registry(String mobile,String password) throws Exception {
        String url = uriBuilder
                .setPath(Identity.registry())
                .build()
                .toString();
        bodyMap.put("mobile",mobile);
        bodyMap.put("password",password);
        String body = gson.toJson(bodyMap);
        request.setUrl(url);
        request.setBody(body);
        return HttpClientUtil.doPost(request);
    }

}
