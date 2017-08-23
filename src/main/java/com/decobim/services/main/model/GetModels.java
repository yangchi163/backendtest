package com.decobim.services.main.model;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ModelModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;

/**
 * 得到项目所有模型信息列表（无分页
 * http://test.api.decobim.com/v1/projects/1/models
 * get
 * Created by Administrator on 2017/8/18.
 */
public class GetModels extends Base {
    public GetModels() {
    }

    public HttpClientResponse getModels(User user, Project project) throws Exception {
        return getModels(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project));
    }

    public HttpClientResponse getModels(String token,String roleId,String projectId) throws Exception {
        String url = uriBuilder
                .setPath(ModelModule.getModels(projectId))
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if (roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        request.setUrl(url);
        return HttpClientUtil.doGet(request);
    }
}
