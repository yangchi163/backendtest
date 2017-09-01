package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/31.
 */
public class ProcessModule {

    public static String addProcess(String projectId){
        String url =  "/v1/projects/{0}/processes";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String deleteProcess(String projectId,String processId){
        String url = "/v1/projects/{0}/processes/{1}";
        url = MessageFormat.format(url,projectId,processId);
        return url;
    }

    public static String modifyProcess(String projectId,String processId){
        String url = "/v1/projects/{0}/processes/{1}";
        url = MessageFormat.format(url,projectId,processId);
        return url;
    }

    public static String getProcess(String projectId,String bidSheetBillInfoIds){
        String url = "/v1/projects/{0}/bills/{1}/processes";
        url = MessageFormat.format(url,projectId,bidSheetBillInfoIds);
        return url;
    }

}
