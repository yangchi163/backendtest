package com.decobim.model.prepareForTest;

/**
 * 使用前先设置projectId,modelId
 * Created by Administrator on 2017/8/22.
 */
public class ModelView {
    private String name;
    private String projectId;
    private String modelId;
    private String modelViewId;
    private String state;
    private String thumbnailUrl;

    public ModelView(String name, String state, String thumbnailUrl) {
        this.name = name;
        this.state = state;
        this.thumbnailUrl = thumbnailUrl;
    }

    public static ModelView modelView1(){
        return new ModelView("吊顶视角图","hello","xxx.xxx.com/shns");
    }
    public static ModelView modelView2(){
        return new ModelView("刷墙视角图","world","xxx.xxx.com/shns");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelViewId() {
        return modelViewId;
    }

    public void setModelViewId(String modelViewId) {
        this.modelViewId = modelViewId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
