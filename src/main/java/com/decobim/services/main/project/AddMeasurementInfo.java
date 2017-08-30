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
 * Created by Administrator on 2017/8/11.
 */
public class AddMeasurementInfo extends Base {

    public AddMeasurementInfo() {
    }

    public HttpClientResponse addMeasurementInfo(User user, Project project) throws Exception {
        return addMeasurementInfo(Tools.getAuth(user),Tools.getProjectId(user,project),
                Tools.getMeasurementBillDbVersionId(user),Tools.getMeasurementQuotaDbVersionId(user));
    }

    public HttpClientResponse addMeasurementInfo(String token,String projectId,String measurementBillDbVersionId,
                                                 String measurementQuotaDbVersionId) throws Exception {
        String url = uriBuilder
                .setPath(ProjectModule.addMeasurementInfo(projectId))
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        bodyMap.put("measurementBillDbVersionId",measurementBillDbVersionId);
        bodyMap.put("measurementQuotaDbVersionId",measurementQuotaDbVersionId);
        request.setBody(gson.toJson(bodyMap));
        request.setUrl(url);
        return HttpClientUtil.doPut(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
