package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/23.
 */
public class BimModelModule {

    public static String getModelTree(String projectId,String modelId){
        String url = "/v1/projects/{0}/models/{1}/modelTree";
        url = MessageFormat.format(url,projectId,modelId);
        return url;
    }

    public static String getBidSheetBillInfoIds(){
        return "getBidSheetBillInfoIds";
    }
}
