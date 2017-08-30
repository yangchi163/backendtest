package com.decobim.services.main.measurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MeasurementModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

import java.net.URISyntaxException;

/**
 * 算量数据库版本信息列表
 * Created by Administrator on 2017/8/11.
 * get
 */
public class GetDbVersionInfo extends Base {

    public GetDbVersionInfo() {
    }

    public HttpClientResponse getDbVersionInfo(User user) throws Exception {
        return getDbVersionInfo(Tools.getAuth(user));
    }

    public HttpClientResponse getDbVersionInfo(String token) throws Exception {
        String url = uriBuilder
                .setPath(MeasurementModule.getDbVersionInfo())
                .build()
                .toString();
        if (token != null){
            request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        }
        request.setUrl(url);
        return HttpClientUtil.doGet(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
