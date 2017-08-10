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
 * 用户管理
 * http://test.api.decobim.com/v1/current-user
 * get
 * Created by Administrator on 2017/8/9.
 */
public class GetCurrentUser extends Base{
    public GetCurrentUser() {
    }
    public HttpClientResponse getCurrentUser(String token) throws Exception {
        String url = uriBuilder
                .setPath(UserModule.getCurrentUser())
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.setUrl(url);
        return HttpClientUtil.doGet(request);
    }
    public HttpClientResponse getCurrentUser(User user) throws Exception {
        return getCurrentUser(Tools.getAuth(user));
    }
}
