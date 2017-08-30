package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.util.List;

/**
 * 根据投标清单id列表查询投标算量清单信息
 * http://test.api.decobim.com/v1/measurement/bidSheetBillInfosByIds
 * post
 * Created by Administrator on 2017/8/28.
 */
public class GetBidSheetBillInfosByIds extends Base {
    public GetBidSheetBillInfosByIds() {
    }

    public HttpClientResponse getBidSheetBillInfosByIds(User user, Project project,List<String> bidSheetBillInfoIds)throws Exception {
        return getBidSheetBillInfosByIds(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getBillVersionId(user,project),bidSheetBillInfoIds);
    }

    public HttpClientResponse getBidSheetBillInfosByIds(String token, String roleId, String projectId, String billVersionId,
                                                        List<String> bidSheetBillInfoIds) throws Exception{
        String url = uriBuilder
                .setPath(MeasurementModule.getBidSheetBillInfosByIds())
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        bodyMap.put("projectId",projectId);
        bodyMap.put("versionId",billVersionId);
        bodyMap.put("bidSheetBillInfoIds",bidSheetBillInfoIds);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
