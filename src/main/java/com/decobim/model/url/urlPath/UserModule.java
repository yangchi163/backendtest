package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/9.
 */
public class UserModule {
    public static String getCurrentUser(){
        return "/v1/current-user";
    }

    public static String getUser(String userId){
        String url = "/v1/users/{0}";
        url = MessageFormat.format(url,userId);
        return url ;
    }

    public static String getUsers(){
        return "/v1/users";
    }
}
