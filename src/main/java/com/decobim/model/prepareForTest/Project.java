package com.decobim.model.prepareForTest;

/**
 * {
 *"address": "金尚路99号",
 *"area": 8888823,
 *"builder": "江苏建工集团第四分局",
 *"buildingType": "剧院",
 *"city": "苏州市",
 *"code": "SZ932",
 *"decorator": "苏州装修装饰公司",
 *"designer": "江苏省第一设计院",
 *"district": "吴中区",
 *"name": "苏州金鸡湖项目",
 *"progress": 88,
 *"province": "江苏省",
 *"remark": "该项目占地面积57600m2，总建筑面积90819m2。"
 *}
 * @author Administrator
 */
public class Project {

    public String address;
    public String area;
    public String builder;
    public String buildingType;
    public String city;
    public String code;
    public String decorator;
    public String designer;
    public String district;
    public String name;
    public String progress;
    public String province;
    public String remark;
    private static Project jingjiLake; //已创建项目
    private static Project yinjiLake;  //已创建项目
    private static Project tiejiLake; //未创建项目
    private static Project tongjiLake;  //未创建项目
    private static Project lvjiLake;
    private static Project errorLake1;  //未创建项目
    private static Project errorLake2;  //未创建项目
    private static Project emptyLake;  //未创建项目


    private Project(String address, String area, String builder, String buildingType, String city, String code, String decorator,
                    String designer, String district, String name, String progress, String province, String remark) {
        this.address = address;
        this.area = area;
        this.builder = builder;
        this.buildingType = buildingType;
        this.city = city;
        this.code = code;
        this.decorator = decorator;
        this.designer = designer;
        this.district = district;
        this.name = name;
        this.progress = progress;
        this.province = province;
        this.remark = remark;
    }

    public static Project lvjiLake() {
        if (lvjiLake == null) {
            lvjiLake = new Project("金尚路55号", "8888823",
                    "江苏建工集团第四分局", "剧院", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "苏州铝鸡湖项目", "88", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return lvjiLake;
    }

    public static Project jingjiLake() {
        if (jingjiLake == null) {
            jingjiLake = new Project("金尚路99号", "8888823",
                    "江苏建工集团第四分局", "剧院啊", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "苏州金鸡湖项目", "88", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return jingjiLake;
    }

    public static Project yinjiLake() {
        if (yinjiLake == null) {
            yinjiLake = new Project("金尚路88号", "8888823",
                    "江苏建工集团第四分局", "剧院", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "苏州银鸡湖项目", "88", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return yinjiLake;
    }

    public static Project tiejiLake() {
        if (tiejiLake == null) {
            tiejiLake = new Project("金尚路77号", "8888823",
                    "江苏建工集团第四分局", "剧院", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "苏州铁鸡湖项目", "88", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return tiejiLake;
    }

    public static Project tongjiLake() {
        if (tongjiLake == null) {
            tongjiLake = new Project("金尚路66号", "8888823",
                    "江苏建工集团第四分局", "剧院", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "苏州铜鸡湖项目", "88", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return tongjiLake;
    }

    public static Project errorLake1() {
        if (errorLake1 == null) {
            errorLake1 = new Project("金尚路66号", "hello",
                    "江苏建工集团第四分局", "剧院", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "苏州铜鸡湖项目", "88", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return errorLake1;
    }

    public static Project errorLake2() {
        if (errorLake2 == null) {
            errorLake2 = new Project("金尚路66号", "8888823",
                    "江苏建工集团第四分局", "剧院", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "苏州铜鸡湖项目", "188", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return errorLake2;
    }

    public static Project emptyLake() {
        if (emptyLake == null) {
            emptyLake = new Project("", "",
                    "江苏建工集团第四分局", "剧院", "苏州市", "SZ932", "苏州装修装饰公司", "江苏省第一设计院", "吴中区",
                    "", "", "江苏省", "该项目占地面积57600m2，总建筑面积90819m2。");
        }
        return emptyLake;
    }

    public String getAddress() {
        return address;
    }

    public String getArea() {
        return area;
    }

    public String getBuilder() {
        return builder;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public String getDecorator() {
        return decorator;
    }

    public String getDesigner() {
        return designer;
    }

    public String getDistrict() {
        return district;
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }

    public String getProvince() {
        return province;
    }

    public String getRemark() {
        return remark;
    }

}
