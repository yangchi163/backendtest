package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.time.Period;

/**
 * 查找某项目下的清单所对应的国标清单的清单编号和清单中的项目名称
 * http://test.api.decobim.com/v1/measurement/projects/1/standardBillCodes/2
 * get
 * Created by Administrator on 2017/8/28.
 */
public class GetStandardBillCodes extends Base {
    public GetStandardBillCodes() {
    }

    public HttpClientResponse getStandardBillCodes(User user,Project project)throws Exception{
        return getStandardBillCodes(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),
                Tools.getMeasurementBillDbVersionId(user));
    }

    public HttpClientResponse getStandardBillCodes(String token, String roleId, String projectId, String billDbVersionId) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.getStandardBillCodes(projectId,billDbVersionId))
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        request.setUrl(url);
        System.out.println(request);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
