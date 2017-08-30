package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 获取清单版本信息列表
 * http://test.api.decobim.com/v1/measurement/getBidBillVersionInfos
 * post
 * Created by Administrator on 2017/8/23.
 */
public class GetBidBillVersionInfos extends Base{
    public GetBidBillVersionInfos() {
    }

    public HttpClientResponse getBidBillVersionInfos(User user, Project project) throws Exception {
        return getBidBillVersionInfos(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project));
    }

    public HttpClientResponse getBidBillVersionInfos(String token,String roleId,String projectId) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.getBidBillVersionInfos())
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if(roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        bodyMap.put("projectId",projectId);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
