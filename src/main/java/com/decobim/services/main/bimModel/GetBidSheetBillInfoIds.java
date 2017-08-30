package com.decobim.services.main.bimModel;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.BimModelModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;
import java.util.List;

/**
 * 获取清单id
 * http://test.api.decobim.com/v1/model/getBidSheetBillInfoIds
 * post
 * Created by Administrator on 2017/8/23.
 */
public class GetBidSheetBillInfoIds extends Base{
    public GetBidSheetBillInfoIds() {
    }

    public HttpClientResponse getBidSheetBillInfoIds(User user, Project project, Model model,List<String> elementIds) throws Exception {
        return getBidSheetBillInfoIds(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getModelId(user,project,model),elementIds);
    }

    public HttpClientResponse getBidSheetBillInfoIds(String token, String roleId, String projectId, String modelId,
                                                     List<String> elementIds) throws Exception {
        String url = uriBuilder
                .setPath(BimModelModule.getBidSheetBillInfoIds())
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        if(token != null){
            request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        }
        bodyMap.put("projectId",projectId);
        bodyMap.put("modelId",modelId);
        bodyMap.put("elementIds",elementIds);
        request.setUrl(url);
        request.setBody(gson.toJson(bodyMap));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
