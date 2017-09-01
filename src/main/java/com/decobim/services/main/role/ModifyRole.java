package com.decobim.services.main.role;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Role;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.RoleModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;


/**
 * 修改角色
 * http://test.api.decobim.com/v1/roles/1
 * put
 * Created by Administrator on 2017/8/16.
 */
public class ModifyRole extends Base {
    public ModifyRole() {
    }

    public HttpClientResponse modifyRole(User user,Role role) throws Exception {
        return modifyRole(Tools.getAuth(user),role.getRoleId(),role);
    }

    public HttpClientResponse modifyRole(String token,String roleId, Role role) throws Exception {
        String url = uriBuilder
                .setPath(RoleModule.modifyRole(roleId))
                .build()
                .toString();
        request.setHeaders(token);
        request.setUrl(url);
        request.setBody(gson.toJson(role));
        return HttpClientUtil.doPut(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
