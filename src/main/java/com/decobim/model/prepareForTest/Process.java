package com.decobim.model.prepareForTest;

/**
 * 使用前设置billId
 * Created by Administrator on 2017/8/31.
 */
public class Process {
    private String name;
    private String billId;
    private String orderId;

    public Process(String name, String orderId) {
        this.name = name;
        this.orderId = orderId;
    }

    public static Process processA(){
        return new Process("工序A","10");
    }

    public static Process processB(){
        return new Process("工序B","20");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
