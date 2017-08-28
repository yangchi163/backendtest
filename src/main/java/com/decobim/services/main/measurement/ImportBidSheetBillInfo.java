package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.BidSheetBill;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 导入投标清单信息
 * http://test.api.decobim.com/v1/measurement/importBidSheetBillInfo
 * post
 * Created by Administrator on 2017/8/23.
 */
public class ImportBidSheetBillInfo extends Base {

    public ImportBidSheetBillInfo() {
    }

    public HttpClientResponse importBidSheetBillInfo(User user, Project project,BidSheetBill bidSheetBill) throws Exception {
        return importBidSheetBillInfo(Tools.getAuth(user),Tools.getRoleId(user,project),bidSheetBill);
    }

    public HttpClientResponse importBidSheetBillInfo(String token, String roleId, BidSheetBill bidSheetBill) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.importBidSheetBillInfo())
                .build()
                .toString();
        if(token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if (roleId != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        request.setUrl(url);
        request.setBody(gson.toJson(bidSheetBill));
        return HttpClientUtil.doPost(request);
    }
}
