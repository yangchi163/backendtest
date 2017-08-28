package com.decobim.model.prepareForTest;

/**
 * 投标清单
 * 使用前设置projectId
 * userId用于验证，验证前设置，使用前设置为null
 * Created by Administrator on 2017/8/23.
 */
public class BidSheetBill {
    private String userId;
    private String projectId;
    private String fileUri;

    public BidSheetBill( String fileUri) {
        this.fileUri = fileUri;
    }

    public static BidSheetBill zhongHang(){
        return new BidSheetBill("http://decobimtest.oss-cn-hangzhou.aliyuncs.com//72cc2360-5e5f-4884-9e7e-84b90967dc4c0.xlsx");
    }

    public String getProjectId() {
        return projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFileUri() {
        return fileUri;
    }
}
