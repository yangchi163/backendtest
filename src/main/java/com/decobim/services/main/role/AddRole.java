package com.decobim.services.main.role;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Role;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.RoleModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;

/**
 * 添加角色
 * http://test.api.decobim.com/v1/roles
 * post
 * 注:role只有rolename
 * Created by Administrator on 2017/8/16.
 */
public class AddRole extends Base{

    public AddRole() {
    }

    public HttpClientResponse addRole(User user,Role role) throws Exception {
        return addRole(Tools.getAuth(user),role);
    }

    public HttpClientResponse addRole(String token, Role role) throws Exception {
        String url = uriBuilder
                .setPath(RoleModule.addRole())
                .build()
                .toString();
        request.setHeaders(token);
        request.setUrl(url);
        request.setBody(gson.toJson(role));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
