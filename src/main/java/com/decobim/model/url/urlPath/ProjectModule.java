package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/10.
 */
public class ProjectModule {

    public static String createProject(){
        return "/v1/projects";
    }

    public static String projectLists(String userId){
        String url = "/v1/users/{0}/projects";
        url = MessageFormat.format(url,userId);
        return url;
    }

    public static String getProject(String projectId){
        String url = "/v1/projects/{0}";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String modifyProject(String projectId){
        String url = "/v1/projects/{0}";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String addMeasurementInfo(String projectId){
        String url = "/v1/projects/{0}/measurement-info";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String deleteProject(String projectId){
        String url = "/v1/projects/{0}";
        url = MessageFormat.format(url,projectId);
        return url;
    }
}
