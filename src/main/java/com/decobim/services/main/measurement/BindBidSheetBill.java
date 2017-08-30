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

import java.util.List;

/**
 * 绑定投标清单到构建
 * http://test.api.decobim.com/v1/measurement/bindBidSheetBill
 * post
 * Created by Administrator on 2017/8/29.
 */
public class BindBidSheetBill extends Base {
    public BindBidSheetBill() {
    }

    public HttpClientResponse bindBidSheetBill(User user, Project project, Model model,List<String> elementIds,
                                               String bidSheetBillInfoId)throws Exception{
        return bindBidSheetBill(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelId(user,project,model),elementIds,bidSheetBillInfoId);
    }

    public HttpClientResponse bindBidSheetBill(String token, String roleId, String projectId, String modelId, List<String> elementIds,
                                               String bidSheetBillInfoId) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.bindBidSheetBill())
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        bodyMap.put("projectId",projectId);
        bodyMap.put("modelId",modelId);
        bodyMap.put("elementIds",elementIds);
        bodyMap.put("bidSheetBillInfoId",bidSheetBillInfoId);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
