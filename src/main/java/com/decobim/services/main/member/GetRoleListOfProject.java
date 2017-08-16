package com.decobim.services.main.member;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MemberModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;


/**
 * 某项目中的所有角色列表(无分页)
 * http://test.api.decobim.com/v1/projects/1/roles
 * get
 * Created by Administrator on 2017/8/15.
 */
public class GetRoleListOfProject extends Base {

    public GetRoleListOfProject() {
    }

    public HttpClientResponse getRoleListOfProject(User user, Project project) throws Exception {
        return getRoleListOfProject(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project));
    }

    public HttpClientResponse getRoleListOfProject(String token,String roleId,String projectId) throws Exception {
        String url = uriBuilder
                .setPath(MemberModule.getRoleListOfProject(projectId))
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        request.setUrl(url);
        return HttpClientUtil.doGet(request);
    }
}
