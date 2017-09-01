package com.decobim.services.main.process;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.ProcessModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 删除工序
 * http://test.api.decobim.com/v1/projects/1/processes/2
 * delete
 * Created by Administrator on 2017/8/31.
 */
public class DeleteProcess extends Base {
    public DeleteProcess() {
    }

    public HttpClientResponse deleteProcess(User user, Project project,String processId) throws Exception {
        return deleteProcess(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),processId);
    }

    public HttpClientResponse deleteProcess(String token,String roleId,String projectId,String processId) throws Exception {
        String url = uriBuilder
                .setPath(ProcessModule.deleteProcess(projectId,processId))
                .build()
                .toString();
        request.setUrl(url);
        request.setHeaders(token,roleId);
        return HttpClientUtil.doDelete(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
