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

import javax.tools.Tool;
import java.net.URISyntaxException;

/**
 * 得到项目的模型视图
 * http://test.api.decobim.com/v1/projects/1/modelviews/2
 * get
 * Created by Administrator on 2017/8/22.
 */
public class GetModelView extends Base{

    public GetModelView() {
    }

    public HttpClientResponse getModelView(User user, Project project, Model model, ModelView modelView) throws Exception {
        return getModelView(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelViewId(user,project,model,modelView));
    }

    public HttpClientResponse getModelView(String token,String roleId,String projectId,String modelViewId) throws Exception {
        String url = uriBuilder
                .setPath(ModelModule.getModelView(projectId,modelViewId))
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
