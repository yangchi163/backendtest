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
        String token = Tools.getAuth(user);
        String url = uriBuilder
                .setPath(UserModule.getUsers())
                .build()
                .toString();
        Map<String,String> headerMap = request.getHeaders();
        headerMap.put(HttpHeadersKey.AUTHORIZATION,token);
        request.setHeaders(headerMap);
        request.setUrl(url);
        return HttpClientUtil.doGet(request);
    }

    public HttpClientResponse getUsers(User user,String pageNum,String pageSize) throws Exception {
        String token = Tools.getAuth(user);
        String url = uriBuilder
                .setPath(UserModule.getUsers())
                .setParameter("pageNum", pageNum)
                .setParameter("pageSize", pageSize)
                .build()
                .toString();
        Map<String,String> headerMap = request.getHeaders();
        headerMap.put(HttpHeadersKey.AUTHORIZATION,token);
        request.setHeaders(headerMap);
        request.setUrl(url);
        return HttpClientUtil.doGet(request);
    }
}
