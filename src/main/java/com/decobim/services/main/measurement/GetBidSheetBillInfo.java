package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import javax.print.attribute.standard.RequestingUserName;

/**
 * 获取投标算量清单信息
 * http://test.api.decobim.com/v1/measurement/bidSheetBillInfo
 * post
 * Created by Administrator on 2017/8/23.
 */
public class GetBidSheetBillInfo extends Base {
    public GetBidSheetBillInfo() {
    }

    public HttpClientResponse getBidSheetBillInfo(User user, Project project,String pageNum, String pageSize) throws Exception {
        return getBidSheetBillInfo(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getBillVersionId(user,project),null,null,pageNum, pageSize);
    }

    public HttpClientResponse getBidSheetBillInfo(String token, String roleId, String projectId, String versionId,
                                                  String geoRegion, String subPart, String pageNum, String pageSize) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.getBidSheetBillInfo())
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        bodyMap.put("projectId",projectId);
        bodyMap.put("versionId",versionId);
        if(geoRegion != null){
            bodyMap.put("geoRegion",geoRegion);
        }
        if (subPart != null){
            bodyMap.put("subPart",subPart);
        }
        bodyMap.put("pageNum",pageNum);
        bodyMap.put("pageSize",pageSize);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request);
    }
}
