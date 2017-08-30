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
 * 某人的项目列表
 * http://test.api.decobim.com/v1/users/{userId}/projects?pageNum=1&pageSize=10000
 * get
 * Created by Administrator on 2017/8/10.
 */
public class ProjectLists extends Base {
    public ProjectLists() {
    }

   public HttpClientResponse projectLists(String userId, String token) throws Exception {
        String url = uriBuilder
                .setPath(ProjectModule.projectLists(userId))
                .setParameter("pageNum","1")
                .setParameter("pageSize","10000")
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        request.setUrl(url);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public HttpClientResponse projectLists(User user) throws Exception {
        return projectLists(Tools.getUserId(user),Tools.getAuth(user));
    }
}