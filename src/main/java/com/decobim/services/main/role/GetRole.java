package com.decobim.services.main.role;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.RoleModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 查看角色
 * http://test.api.decobim.com/v1/roles/1
 * get
 * Created by Administrator on 2017/8/16.
 */
public class GetRole extends Base {
    public GetRole() {
    }

    public HttpClientResponse getRole(User user,String roleId) throws Exception {
        return getRole(Tools.getAuth(user),roleId);
    }

    public HttpClientResponse getRole(String token,String roleId) throws Exception {
        String url = uriBuilder
                .setPath(RoleModule.getRole(roleId))
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.setUrl(url);
        //System.out.println("request:" + request);
        return HttpClientUtil.doGet(request);
    }
}
