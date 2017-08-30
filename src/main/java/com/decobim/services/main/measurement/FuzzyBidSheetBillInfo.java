package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;
import org.testng.annotations.Test;

/**
 * 模糊查询投标算量清单信息
 * http://test.api.decobim.com/v1/measurement/fuzzyBidSheetBillInfo
 * post
 * Created by Administrator on 2017/8/28.
 */
public class FuzzyBidSheetBillInfo extends Base {
    public FuzzyBidSheetBillInfo() {
    }

    public HttpClientResponse fuzzyBidSheetBillInfo(User user, Project project, String name, String pageNum,
                                                    String pageSize) throws Exception {
        return fuzzyBidSheetBillInfo(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getBillVersionId(user,project),name, pageNum, pageSize);

    }

    public HttpClientResponse fuzzyBidSheetBillInfo(String token, String roleId, String projectId, String versionId, String name,
                                                    String pageNum, String pageSize) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.fuzzyBidSheetBillInfo())
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION, token);
        request.getHeaders().put(HttpHeadersKey.ROLEID, roleId);
        bodyMap.put("projectId", projectId);
        bodyMap.put("versionId", versionId);
        bodyMap.put("name", name);
        bodyMap.put("pageNum", pageNum);
        bodyMap.put("pageSize", pageSize);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
