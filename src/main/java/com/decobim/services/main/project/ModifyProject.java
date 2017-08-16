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
 * Created by Administrator on 2017/8/10.
 */
public class ModifyProject extends Base {
    public ModifyProject() {
    }

    public HttpClientResponse modifyProect(User user,Project before,Project after) throws Exception {
        return modifyProject(Tools.getAuth(user),Tools.getRoleId(user,before),Tools.getProjectId(user,before), after);
        }
    public HttpClientResponse modifyProject(String token, String roleId, String projectId, Project after) throws Exception {
        String url = uriBuilder
                .setPath(ProjectModule.modifyProject(projectId))
                .build()
                .toString();
        if(token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if (roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        request.setUrl(url);
        request.setBody(gson.toJson(after));
        return HttpClientUtil.doPut(request);
    }
}
