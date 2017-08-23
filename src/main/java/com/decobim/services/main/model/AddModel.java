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
import com.sun.org.apache.xpath.internal.operations.Mod;


/**
 * 批量上传文件信息
 * http://test.api.decobim.com/v1/projects/1/model
 * post
 * Created by Administrator on 2017/8/18.
 */
public class AddModel extends Base{

    public AddModel() {
    }

    public HttpClientResponse addModel(User user, Project project, Model model) throws Exception {
        return addModel(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),model);
    }

    public HttpClientResponse addModel(String token, String roleId, String projectId, Model model) throws Exception {
        String url = uriBuilder
                .setPath(ModelModule.addModel(projectId))
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if(roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        request.setUrl(url);
        request.setBody(gson.toJson(model));
        return HttpClientUtil.doPost(request);
    }
}
