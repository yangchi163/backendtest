package com.decobim.services.main.process;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Process;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ProcessModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 新增工序
 * http://test.api.decobim.com/v1/projects/1/processes
 * post
 * Created by Administrator on 2017/8/31.
 */
public class AddProcess extends Base {
    public AddProcess() {
    }

    public HttpClientResponse addProcess(User user, Project project, Process process) throws Exception {
        return addProcess(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),process);
    }

    public HttpClientResponse addProcess(String token,String roleId,String projectId,Process process) throws Exception {
        String url = uriBuilder
                .setPath(ProcessModule.addProcess(projectId))
                .build()
                .toString();
        request.setHeaders(token,roleId);
        request.setUrl(url);
        request.setBody(gson.toJson(process));
        //System.out.println(request);
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
