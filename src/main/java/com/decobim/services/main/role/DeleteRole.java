package com.decobim.services.main.role;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.RoleModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;

/**
 * 删除角色
 * http://test.api.decobim.com/v1/roles/1
 * delete
 * Created by Administrator on 2017/8/16.
 */
public class DeleteRole extends Base {

    public DeleteRole() {
    }

    public HttpClientResponse deleteRole(User user,String roleId) throws Exception {
        return deleteRole(Tools.getAuth(user),roleId);
    }

    public HttpClientResponse deleteRole(String token,String roleId) throws Exception {
        String url = uriBuilder
                .setPath(RoleModule.deleteRole(roleId))
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.setUrl(url);
        return HttpClientUtil.doDelete(request);
    }
}
