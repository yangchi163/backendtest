package com.decobim.model.prepareForTest;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/18.
 */
public class Model {
    private String name;
    private String projectId;
    private String modelExtraId;
    private List<Map<String,String>> list;
    private Map<String,String> sdb;
    private Map<String,String> svf;
    private List<String> drawing2dUris;
    private String modelId;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Model() {
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

    public String getModelExtraId() {
        return modelExtraId;
    }

    public void setModelExtraId(String modelExtraId) {
        this.modelExtraId = modelExtraId;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }

    public Map<String, String> getSdb() {
        return sdb;
    }

    public void setSdb(Map<String, String> sdb) {
        this.sdb = sdb;
    }

    public Map<String, String> getSvf() {
        return svf;
    }

    public void setSvf(Map<String, String> svf) {
        this.svf = svf;
    }

    public List<String> getDrawing2dUris() {
        return drawing2dUris;
    }

    public void setDrawing2dUris(List<String> drawing2dUris) {
        this.drawing2dUris = drawing2dUris;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", projectId='" + projectId + '\'' +
                ", modelExtraId='" + modelExtraId + '\'' +
                ", list=" + list +
                ", sdb=" + sdb +
                ", svf=" + svf +
                ", drawing2dUris=" + drawing2dUris +
                '}';
    }
}
