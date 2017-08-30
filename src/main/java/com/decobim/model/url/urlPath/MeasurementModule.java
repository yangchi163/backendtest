package com.decobim.model.url.urlPath;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/11.
 */
public class MeasurementModule {

    public static String getDbVersionInfo() {
        return "/v1/measurement/dbVersionInfo";
    }

    public static String importBidSheetBillInfo() {
        return "/v1/measurement/importBidSheetBillInfo";
    }

    public static String getBidBillVersionInfos() {
        return "/v1/measurement/getBidBillVersionInfos";
    }

    public static String getBidSheetBillGeoRegions() {
        return "/v1/measurement/projects/bidSheetBillGeoRegions";
    }

    public static String getBidSheetBillSubParts() {
        return "/v1/measurement/projects/bidSheetBillSubParts";
    }

    public static String getBidSheetBillInfo() {
        return "/v1/measurement/bidSheetBillInfo";
    }

    public static String getAllBidSheetBillInfo() {
        return "/v1/measurement/allBidSheetBillInfo";
    }

    public static String fuzzyBidSheetBillInfo() {
        return "/v1/measurement/fuzzyBidSheetBillInfo";
    }

    public static String getStandardBillCodes(String projectId, String billDbVersionId) {
        String url = "/v1/measurement/projects/{0}/standardBillCodes/{1}";
        url = MessageFormat.format(url, projectId, billDbVersionId);
        return url;
    }

    public static String getBidSheetBillInfosByIds(){
        return "/v1/measurement/bidSheetBillInfosByIds";
    }

    public static String getBillModelTree(){
        return "/v1/measurement/getBillModelTree";
    }

    public static String bindBidSheetBill(){
        return "/v1/measurement/bindBidSheetBill";
    }

    public static String unbindBidSheetBillInfo(){
        return "/v1/measurement/unbindBidSheetBillInfo";
    }
}
