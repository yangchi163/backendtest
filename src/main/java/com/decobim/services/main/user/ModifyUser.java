package com.decobim.services.main.user;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.UserModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.util.Map;

/**
 * 修改用户
 * url：test.api.decobim.com/v1/users/136840870473730
 * put
 * Created by jtl on 2017/8/10.
 */
public class ModifyUser extends Base{
    public ModifyUser(){}

    public HttpClientResponse modifyUser(User user,User other,String name)throws Exception{
        String token = Tools.getAuth(user);
        String userId = Tools.getUserId(other);
        String url = uriBuilder
                .setPath(UserModule.getUser(userId))
                .build()
                .toString();
        bodyMap.put("name",name);
        Map<String,String> headerMap = request.getHeaders();
        headerMap.put(HttpHeadersKey.AUTHORIZATION,token);
        request.setHeaders(headerMap);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        System.out.println(request);
        return HttpClientUtil.doPut(request);

    }
}
