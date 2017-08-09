package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/8.
 */
public class Identity {
    public static String registry(){
        return "/v1/identity/registry";
    }

    public static String ree(String projectId){
        String url = "/v1/project/{0}/invitations";
        url = MessageFormat.format(url,projectId);
        return url;
    }
}
