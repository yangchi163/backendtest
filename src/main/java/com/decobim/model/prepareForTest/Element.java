package com.decobim.model.prepareForTest;

/**
 * 构建
 * Created by Administrator on 2017/8/23.
 */
public class Element {
    private String title;
    private String elementId;

    private Element(String title, String elementId) {
        this.title = title;
        this.elementId = elementId;
    }

    public static Element A(){
        return new Element("基本墙 [328890]","56bf4ff3-874b-4948-a4d0-fea768deb7b4-000504ba");
    }

    public static Element B(){
        return new Element("基本墙 [328979]","56bf4ff3-874b-4948-a4d0-fea768deb7b4-00050513");
    }

    public String getTitle() {
        return title;
    }

    public String getElementId() {
        return elementId;
    }
}
