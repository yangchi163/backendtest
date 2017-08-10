package com.decobim.services.main.user;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.UserUrl;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.util.Map;

/**
 * 获取用户信息
 * uri：api.decobim.com/v1/users/1
 * get
 * Created by jtl on 2017/8/10.
 */
public class GetUser extends Base{
    public GetUser(){}

    public HttpClientResponse getUser(User user,User other)throws Exception{
        String userId = Tools.getUserId(other);
        String token = Tools.getAuth(user);
        String roleId = "100";
        String url = uriBuilder
                .setPath(UserUrl.getUser(userId))
                .build()
                .toString();
        Map<String,String> headerMap = request.getHeaders();
        headerMap.put(HttpHeadersKey.AUTHORIZATION,token);
        headerMap.put(HttpHeadersKey.ROLEID,roleId);
        request.setHeaders(headerMap);
        request.setUrl(url);
        return HttpClientUtil.doGet(request);
    }

}
