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
 * 修改工序
 * http://test.api.decobim.com/v1/projects/1/processes/2
 * put
 * Created by Administrator on 2017/8/31.
 */
public class ModifyProcess extends Base {
    public ModifyProcess() {
    }

    public HttpClientResponse modifyProcess(User user, Project project,String processId,Process process) throws Exception {
        return modifyProcess(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),processId,process);
    }

    public HttpClientResponse modifyProcess(String token, String roleId, String projectId, String processId, Process process) throws Exception {
        String url = uriBuilder
                .setPath(ProcessModule.modifyProcess(projectId,processId))
                .build()
                .toString();
        request.setUrl(url);
        request.setHeaders(token,roleId);
        request.setBody(gson.toJson(process));
        return HttpClientUtil.doPut(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
