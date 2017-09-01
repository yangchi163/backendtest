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

/**
 * 删除模型信息
 * http://test.api.decobim.com/v1/projects/1/models/2
 * delete
 * Created by Administrator on 2017/8/18.
 */
public class DeleteModel extends Base{

    public DeleteModel() {
    }

    public HttpClientResponse deleteModel(User user, Project project, Model model) throws Exception {
        return deleteModel(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelId(user,project,model));
    }

    public HttpClientResponse deleteModel(String token,String roleId,String projectId,String modelId) throws Exception {
        String url = uriBuilder
                .setPath(ModelModule.deleteModel(projectId,modelId))
                .build()
                .toString();
        request.setHeaders(token,roleId);
        request.setUrl(url);
        return HttpClientUtil.doDelete(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
