package com.decobim.services.main.model;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.ModelView;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ModelModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 新增模型视图
 * http://test.api.decobim.com/v1/projects/1/models/2/modelviews
 * post
 * Created by Administrator on 2017/8/22.
 */
public class AddModelView extends Base{

    public AddModelView() {
    }

    public HttpClientResponse addModelView(User user, Project project, Model model,ModelView modelView) throws Exception {
        return addModelView(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelId(user,project,model),modelView);
    }

    public HttpClientResponse addModelView(String token, String roleId, String projectId, String modelId, ModelView modelView) throws Exception {
        String url = uriBuilder
                .setPath(ModelModule.addModelView(projectId,modelId))
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if(roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        request.setUrl(url);
        request.setBody(gson.toJson(modelView));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
