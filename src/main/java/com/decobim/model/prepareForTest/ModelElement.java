package com.decobim.model.prepareForTest;

/**
 * Created by Administrator on 2017/8/29.
 */
public enum ModelElement {
    TrueElement("56bf4ff3-874b-4948-a4d0-fea768deb7b4-00050415","楼板 [328725]"),FalseElement("hehe","notExsit");
    private String id;
    private String title;

    ModelElement(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
