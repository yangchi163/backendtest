package com.decobim.model.prepareForTest;

/**
 * Created by Administrator on 2017/8/15.
 */
public class Role {
    private String name;
    private String roleId;

    public Role(String roleId, String name) {
        this.name = name;
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public static Role guanLiYuan(){
        return new Role("100","管理员");
    }
    public static Role shiGongYuan(){
        return new Role("110","施工员");
    }
    public static Role caiLiaoYuan(){
        return new Role("120","材料员");
    }
    public static Role anQuanYuan(){
        return new Role("130","安全员");
    }
    public static Role cangGuanYuan(){
        return new Role("140","仓管员");
    }
    public static Role zhiLiangYuan(){
        return new Role("150","质量员");
    }
    public static Role xiangMuJingLi(){
        return new Role("160","项目经理");
    }
    public static Role shenHuaSheJi(){
        return new Role("170","深化设计");
    }
    public static Role yuJueSuan(){
        return new Role("180","预决算");
    }
    public static Role chengxuyuan(){
        return new Role("","程序员");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        return roleId != null ? roleId.equals(role.roleId) : role.roleId == null;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
