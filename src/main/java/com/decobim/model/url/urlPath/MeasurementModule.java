package com.decobim.model.url.urlPath;

/**
 * Created by Administrator on 2017/8/11.
 */
public class MeasurementModule {

    public static String getDbVersionInfo(){
        return "/v1/measurement/dbVersionInfo";
    }

    public static String importBidSheetBillInfo(){
        return "/v1/measurement/importBidSheetBillInfo";
    }

    public static String getBidBillVersionInfos(){
        return "/v1/measurement/getBidBillVersionInfos";
    }

    public static String getBidSheetBillGeoRegions(){
        return "/v1/measurement/projects/bidSheetBillGeoRegions";
    }

    public static String getBidSheetBillSubParts(){
        return "/v1/measurement/projects/bidSheetBillSubParts";
    }

    public static String getBidSheetBillInfo(){
        return "/v1/measurement/bidSheetBillInfo";
    }

    public static String getAllBidSheetBillInfo(){
        return "/v1/measurement/allBidSheetBillInfo";
    }
}
