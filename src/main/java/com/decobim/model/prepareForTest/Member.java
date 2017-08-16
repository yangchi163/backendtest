package com.decobim.model.prepareForTest;

/**
 * 使用前需要先设置projectId，roleId，userId,mobile
 * 其中mobile和userId只能赋值其中的一个
 * Created by Administrator on 2017/8/15.
 */
public class Member {

    private String mobile;
    private String projectId;
    private String remark;
    private String roleId;
    private String scope;
    private String userId;

    public Member(String remark, String scope) {
        this.remark = remark;
        this.scope = scope;
    }

    public static Member memberA(){
        return new Member("备注A","负责这栋楼的1-12层");
    }

    public static Member memberB(){
        return new Member("备注B","负责这栋楼的13-14层");
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
