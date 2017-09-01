package com.decobim.services.main.user;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.UserModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;
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
        return getUser(Tools.getAuth(user),"100",Tools.getUserId(other));
    }

    public HttpClientResponse getUser(String token,String roleId,String userId) throws Exception {
        String url = uriBuilder
                .setPath(UserModule.getUser(userId))
                .build()
                .toString();
        request.setHeaders(token,roleId);
        request.setUrl(url);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
