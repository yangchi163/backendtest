package com.decobim.services.main.project;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ProjectModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;

/**
 * 查看项目
 * http://test.api.decobim.com/v1/projects/{projectId}
 * get
 * Created by Administrator on 2017/8/10.
 */
public class GetProject extends Base{
    public GetProject() {
    }
    public HttpClientResponse getProject(User user, Project project) throws Exception {
        return getProject(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project));
    }

    public HttpClientResponse getProject(String token,String roleId,String projectId) throws URISyntaxException {
        String url = uriBuilder
                .setPath(ProjectModule.getProject(projectId))
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if (roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        request.setUrl(url);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
