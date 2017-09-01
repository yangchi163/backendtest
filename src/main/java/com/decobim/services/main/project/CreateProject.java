package com.decobim.services.main.project;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ProjectModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.util.Map;

/**
 * 创建项目
 * http://test.api.decobim.com/v1/projects
 * post
 * Created by Administrator on 2017/8/10.
 */
public class CreateProject extends Base{
    public CreateProject() {
    }
    public HttpClientResponse createProject(User user, Project project) throws Exception {
        return createProject(Tools.getAuth(user),project);
    }

    public HttpClientResponse createProject(String token, Project project) throws Exception {
        String url = uriBuilder
                .setPath(ProjectModule.createProject())
                .build()
                .toString();
        request.setHeaders(token);
        request.setUrl(url);
        request.setBody(gson.toJson(project));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
