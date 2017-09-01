package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 获取基于清单的模型树结构
 * http://test.api.decobim.com/v1/measurement/getBillModelTree
 * post
 * Created by Administrator on 2017/8/29.
 */
public class GetBillModelTree extends Base {
    public GetBillModelTree() {
    }

    public HttpClientResponse getBillModelTree(User user, Project project, Model model) throws Exception {
        return getBillModelTree(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelId(user,project,model),Tools.getBillVersionId(user,project));
    }

    public HttpClientResponse getBillModelTree(String token,String roleId,String projectId,String modelId,String billVersionId) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.getBillModelTree())
                .build()
                .toString();
        request.setHeaders(token,roleId);
        bodyMap.put("projectId",projectId);
        bodyMap.put("modelId",modelId);
        bodyMap.put("versionId",billVersionId);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
