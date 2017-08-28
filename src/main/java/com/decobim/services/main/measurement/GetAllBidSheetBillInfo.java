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
 * 获取所有投标算量清单信息
 * http://test.api.decobim.com/v1/measurement/allBidSheetBillInfo
 * post
 * Created by Administrator on 2017/8/23.
 */
public class GetAllBidSheetBillInfo extends Base {
    public GetAllBidSheetBillInfo() {
    }

    public HttpClientResponse getAllBidSheetBillInfo(User user, Project project) throws Exception{
        return getAllBidSheetBillInfo(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getBillVersionId(user,project));
    }

    public HttpClientResponse getAllBidSheetBillInfo(String token,String roleId,String projectId,String versionId) throws Exception{
        String url = uriBuilder
                .setPath(MeasurementModule.getAllBidSheetBillInfo())
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        bodyMap.put("projectId",projectId);
        bodyMap.put("versionId",versionId);
        request.setBody(gson.toJson(bodyMap));
        request.setUrl(url);
        return HttpClientUtil.doPost(request);
    }
}
