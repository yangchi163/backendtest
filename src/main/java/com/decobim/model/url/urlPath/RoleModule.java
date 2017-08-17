package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/16.
 */
public class RoleModule {

    public static String addRole(){
        return "/v1/roles";
    }

    public static String deleteRole(String roleId){
        String url = "/v1/roles/{0}";
        url = MessageFormat.format(url,roleId);
        return url;
    }

    public static String modifyRole(String roleId){
        String url = "/v1/roles/{0}";
        url = MessageFormat.format(url,roleId);
        return url;
    }

    public static String getRole(String roleId){
        String url = "/v1/roles/{0}";
        url = MessageFormat.format(url,roleId);
        return url;
    }

    public static String getRoleList(){
        return "/v1/roles";
    }
}
