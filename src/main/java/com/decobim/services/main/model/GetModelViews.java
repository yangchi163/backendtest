package com.decobim.services.main.model;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ModelModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;

/**
 * 得到项目的模型视图列表
 * http://test.api.decobim.com/v1/projects/1/models/2/modelviews
 * get
 * Created by Administrator on 2017/8/22.
 */
public class GetModelViews extends Base {

    public GetModelViews() {
    }

    public HttpClientResponse getModelViews(User user, Project project, Model model) throws Exception {
        return getModelViews(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelId(user,project,model));
    }

    public HttpClientResponse getModelViews(String token,String roleId,String projectId,String modelId) throws Exception {
        String url = uriBuilder
                .setPath(ModelModule.getModelViews(projectId,modelId))
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if(roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        request.setUrl(url);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
