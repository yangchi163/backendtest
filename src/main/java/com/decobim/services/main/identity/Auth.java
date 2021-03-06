package com.decobim.services.main.identity;

import com.decobim.model.prepareForTest.User;
import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.url.urlPath.IdentityModule;
import com.decobim.services.main.Base;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 获得token
 * url: http://api.decobim.com/v1/identity/auth
 * Created by Administrator on 2017/8/9.
 */
public class Auth extends Base {
    public Auth() {
    }
    public HttpClientResponse auth(String mobile,String password) throws Exception {
        String url = uriBuilder
                .setPath(IdentityModule.auth())
                .build()
                .toString();
        if(mobile != null){
            bodyMap.put("mobile",mobile);
        }
        if (password != null){
            bodyMap.put("password",password);
        }
        request.setUrl(url);
        request.setHeaders();
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public HttpClientResponse auth(User user) throws Exception {
        return auth(user.getUserName(),user.getUserPwd());
    }
}
