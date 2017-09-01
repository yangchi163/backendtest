package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/31.
 */
public class CostModule {

    public static String AddCostItems(String projectId){
        String url = "/v1/projects/{0}/cost-items";
        url = MessageFormat.format(url,projectId);
        return url;
    }
}
