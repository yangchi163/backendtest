package com.decobim.services.main.role;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.RoleModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;


/**
 * 角色列表
 * http://test.api.decobim.com/v1/roles?pageNum=1&pageSize=10
 * get
 * Created by Administrator on 2017/8/16.
 */
public class GetRoleList extends Base {

    public GetRoleList() {
    }

    public HttpClientResponse getRoleList(User user) throws Exception {
        return getRoleList(Tools.getAuth(user),null,null);
    }

    public HttpClientResponse getRoleList(String token,String pageNum,String pageSize) throws Exception {
        if (pageNum != null){
            uriBuilder.setParameter("pageNum",pageNum);
        }
        if (pageSize != null){
            uriBuilder.setParameter("pageSize",pageSize);
        }
        String url = uriBuilder
                .setPath(RoleModule.getRoleList())
                .build()
                .toString();
        request.setHeaders(token);
        request.setUrl(url);
        //System.out.println(request);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
