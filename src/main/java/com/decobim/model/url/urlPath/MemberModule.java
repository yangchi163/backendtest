package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/10.
 */
public class MemberModule {

    public static String getRoleListOfSbInProject(String userId,String projectId){
        String url = "http://test.api.decobim.com/v1/users/{0}/projects/{1}/roles";
        url = MessageFormat.format(url,userId,projectId);
        return url;
    }
}
