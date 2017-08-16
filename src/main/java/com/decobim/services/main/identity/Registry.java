package com.decobim.services.main.identity;

import com.decobim.model.prepareForTest.User;
import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.url.urlPath.IdentityModule;
import com.decobim.services.main.Base;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 创建一个新用户
 * url: http://api.decobim.com/v1/identity/registry
 * post
 * Created by Administrator on 2017/8/8.
 */
public class Registry extends Base {
    public Registry() {
    }
    public HttpClientResponse registry(User user) throws Exception {
        return registry(user.getUserName(),user.getUserPwd());
    }

    public HttpClientResponse registry(String mobile,String password) throws Exception {
        String url = uriBuilder
                .setPath(IdentityModule.registry())
                .build()
                .toString();
        if(mobile != null){
            bodyMap.put("mobile",mobile);
        }
        if(password != null){
            bodyMap.put("password",password);
        }
        String body = gson.toJson(bodyMap);
        request.setUrl(url);
        request.setBody(body);
        return HttpClientUtil.doPost(request);
    }

}
