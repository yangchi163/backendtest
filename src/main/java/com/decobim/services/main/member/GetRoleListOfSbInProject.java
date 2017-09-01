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
 * 某人在某项目中的角色列表
 * http://test.api.decobim.com/v1/users/{userId}/projects/{projectId}/roles
 * Created by Administrator on 2017/8/10.
 */
public class GetRoleListOfSbInProject extends Base{

    public GetRoleListOfSbInProject() {
    }

    public  HttpClientResponse getRoleListOfSbInProject(User user, Project project) throws Exception {
        return getRoleListOfSbInProject(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getUserId(user),Tools.getProjectId(user,project));
    }
    public HttpClientResponse getRoleListOfSbInProject(String token,String roleId,String userId,String projectId) throws Exception {
        String url = uriBuilder
                .setPath(MemberModule.getRoleListOfSbInProject(userId,projectId))
                .build()
                .toString();
        request.setHeaders(token,roleId);
        request.setUrl(url);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
