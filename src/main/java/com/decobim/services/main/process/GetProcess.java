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
 * 按清单查看工序
 * http://test.api.decobim.com/v1/projects/2/bills/1/processes
 * get
 * Created by Administrator on 2017/8/31.
 */
public class GetProcess extends Base {
    public GetProcess() {
    }

    public HttpClientResponse getProcess(User user, Project project,String bidSheetBillInfoIds) throws Exception{
        return getProcess(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),bidSheetBillInfoIds);
    }

    public HttpClientResponse getProcess(String token,String roleId,String projectId,String bidSheetBillInfoIds) throws Exception {
        String url = uriBuilder
                .setPath(ProcessModule.getProcess(projectId,bidSheetBillInfoIds))
                .build()
                .toString();
        request.setUrl(url);
        request.setHeaders(token,roleId);
        System.out.println(request);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
