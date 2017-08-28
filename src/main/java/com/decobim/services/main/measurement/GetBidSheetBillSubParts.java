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
 * 获取投标算量清单部位列表
 * http://test.api.decobim.com/v1/measurement/projects/bidSheetBillSubParts
 * post
 * Created by Administrator on 2017/8/23.
 */
public class GetBidSheetBillSubParts extends Base{
    public GetBidSheetBillSubParts() {
    }

    public HttpClientResponse getBidSheetBillSubParts(User user, Project project) throws Exception{
        return getBidSheetBillSubParts(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getBillVersionId(user,project));
    }

    public HttpClientResponse getBidSheetBillSubParts(String token,String roleId,String projectId,String versionId) throws Exception{
        String url = uriBuilder
                .setPath(MeasurementModule.getBidSheetBillSubParts())
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
        return HttpClientUtil.doPost(request);
    }
}
