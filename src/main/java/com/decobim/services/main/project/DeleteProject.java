package com.decobim.services.main.project;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ProjectModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;


/**
 * 删除项目
 * http://test.api.decobim.com/v1/projects/1
 * delete
 * Created by Administrator on 2017/8/11.
 */
public class DeleteProject extends Base {
    public DeleteProject() {
    }
    public HttpClientResponse deleteProject(User user, Project project) throws Exception {
        return deleteProject(Tools.getAuth(user),Tools.getProjectId(user,project));
    }
    public HttpClientResponse deleteProject(String token,String projectId) throws Exception {
        String url = uriBuilder
                .setPath(ProjectModule.deleteProject(projectId))
                .build()
                .toString();
        request.setHeaders(token);
        request.setUrl(url);
        return HttpClientUtil.doDelete(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
