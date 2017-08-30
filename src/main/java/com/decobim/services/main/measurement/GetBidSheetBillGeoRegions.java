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
 * 获取投标算量清单区域列表
 * http://test.api.decobim.com/v1/measurement/projects/bidSheetBillGeoRegions
 * post
 * Created by Administrator on 2017/8/23.
 */
public class GetBidSheetBillGeoRegions extends Base {
    public GetBidSheetBillGeoRegions() {
    }

    public HttpClientResponse getBidSheetBillGeoRegions(User user, Project project) throws Exception{
        return getBidSheetBillGeoRegions(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getBillVersionId(user,project));
    }

    public HttpClientResponse getBidSheetBillGeoRegions(String token,String roleId,String projectId,String versionId) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.getBidSheetBillGeoRegions())
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if(roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        bodyMap.put("projectId",projectId);
        bodyMap.put("versionId",versionId);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
