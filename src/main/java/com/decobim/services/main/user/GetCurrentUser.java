package com.decobim.services.main.user;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.url.urlPath.UserModule;
import com.decobim.services.main.Base;
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
    public HttpClientResponse getCurrentUser(String token,String roleId) throws Exception {
        String url = uriBuilder
                .setPath(UserModule.getCurrentUser())
                .build()
                .toString();
        Map<String,String> headers = request.getHeaders();
        headers.put(HttpHeadersKey.AUTHORIZATION,token);
        headers.put(HttpHeadersKey.ROLEID,roleId);
        request.setUrl(url);
        request.setHeaders(headers);
        return HttpClientUtil.doGet(request);
    }
}
