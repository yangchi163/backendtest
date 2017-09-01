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
 * 获取用户列表
 * url：.api.decobim.com/v1/users?pageNum=1&pageSize=10
 *get
 * Created by jtl on 2017/8/10.
 */
public class GetUsers extends Base {
    public GetUsers(){}

    public HttpClientResponse getUsers(User user)throws Exception{
        return getUsers(Tools.getAuth(user));
    }

    public HttpClientResponse getUsers(String token)throws Exception{
        String url = uriBuilder
                .setPath(UserModule.getUsers())
                .build()
                .toString();
        request.setHeaders(token);
        request.setUrl(url);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
