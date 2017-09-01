package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;

/**
 * 从构建解绑清单
 * http://test.api.decobim.com/v1/measurement/unbindBidSheetBillInfo
 * post
 * Created by Administrator on 2017/8/29.
 */
public class UnbindBidSheetBillInfo extends Base {
    public UnbindBidSheetBillInfo() {
    }

    public HttpClientResponse unbindBidSheetBillInfo(User user, Project project, String bidSheetBillInfoId) throws Exception {
        return unbindBidSheetBillInfo(Tools.getAuth(user), Tools.getRoleId(user, project), bidSheetBillInfoId);
    }

    public HttpClientResponse unbindBidSheetBillInfo(String token, String roleId, String bidSheetBillInfoId) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.unbindBidSheetBillInfo())
                .build()
                .toString();
        request.setHeaders(token,roleId);
        bodyMap.put("bidSheetBillInfoId", bidSheetBillInfoId);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
