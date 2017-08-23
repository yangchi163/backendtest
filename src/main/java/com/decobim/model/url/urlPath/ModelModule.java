package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/18.
 */
public class ModelModule {

    public static String getModels(String projectId){
        String url = "/v1/projects/{0}/models";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String addModel(String projectId){
        String url = "/v1/projects/{0}/model";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String deleteModel(String projectId,String modelId){
        String url = "/v1/projects/{0}/models/{1}";
        url = MessageFormat.format(url,projectId,modelId);
        return url;
    }

    public static String getModel(String projectId,String modelId){
        String url = "/v1/projects/{0}/models/{1}";
        url = MessageFormat.format(url,projectId,modelId);
        return url;
    }

    public static String getModelViews(String projectId,String modelId){
        String url = "/v1/projects/{0}/models/{1}/modelviews";
        url = MessageFormat.format(url,projectId,modelId);
        return url;
    }

    public static String getModelView(String projectId,String modelViewId){
        String url = "/v1/projects/{0}/modelviews/{1}";
        url = MessageFormat.format(url,projectId,modelViewId);
        return url;
    }

    public static String addModelView(String projectId,String modelId){
        String url = "/v1/projects/{0}/models/{1}/modelviews";
        url = MessageFormat.format(url,projectId,modelId);
        return url;
    }
}
