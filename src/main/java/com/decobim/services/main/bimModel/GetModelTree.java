package com.decobim.services.main.bimModel;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.BimModelModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;


/**
 * 获取模型树结构
 * http://test.api.decobim.com/v1/projects/1/models/2/modelTree
 * get
 * Created by Administrator on 2017/8/23.
 */
public class GetModelTree extends Base{

    public GetModelTree() {
    }

    public HttpClientResponse getModelTree(User user, Project project, Model model) throws Exception {
        return getModelTree(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelId(user,project,model));
    }

    public HttpClientResponse getModelTree(String token,String roleId,String projectId,String modelId) throws Exception {
        String url = uriBuilder
                .setPath(BimModelModule.getModelTree(projectId,modelId))
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
