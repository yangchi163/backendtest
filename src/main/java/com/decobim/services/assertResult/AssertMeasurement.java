package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.BidSheetBill;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

import static org.testng.Assert.*;
/**
 * Created by Administrator on 2017/8/23.
 */
public class AssertMeasurement extends AssertBase{

    public static void getDbVersionInfo(HttpClientResponse response){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        assertTrue(root.has("billVersions"),"no billVersions");
        assertTrue(root.has("quotaVersions"),"no quotaVersions");
        JsonArray billVersions = root.getAsJsonArray("billVersions");
        JsonArray quotaVersions = root.getAsJsonArray("quotaVersions");
        Iterator<JsonElement> it = billVersions.iterator();
        verifyDbVersionInfo(it);
        it = quotaVersions.iterator();
        verifyDbVersionInfo(it);
    }

    public static void importBidSheetBillInfo(HttpClientResponse response){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        assertTrue(root.has("channel"),"no channel");
        assertTrue(root.has("dbId"),"no dbId");
    }

    public static void getBidBillVersionInfos(HttpClientResponse response,int number){
        getBidBillVersionInfos(response,null,number);
    }
    //number为0时，bidSheetBill只能是null
    public static void getBidBillVersionInfos(HttpClientResponse response, BidSheetBill bidSheetBill,int number){
        if (number == 0){
            assertTrue(response.getBody().contains("notFound"),"no notFound in body");
        }else {
            JsonObject root = (JsonObject) parser.parse(response.getBody());
            JsonArray versionInfos = root.getAsJsonArray("versionInfos");
            assertEquals(number,versionInfos.size());
            Iterator<JsonElement> it = versionInfos.iterator();
            while (it.hasNext()){
                JsonObject obj = (JsonObject) it.next();
                assertTrue(obj.has("versionId"),"no versionId");
                assertEquals(obj.get("userId").getAsString(),bidSheetBill.getUserId(),"userId error");
                assertEquals(obj.get("fileUri").getAsString(),bidSheetBill.getFileUri(),"fileUri error");
                assertTrue(obj.has("timestamp"),"no timestamp");
            }
        }
    }

    private static void verifyDbVersionInfo(Iterator<JsonElement> iterator){
        while (iterator.hasNext()){
            JsonObject obj = (JsonObject) iterator.next();
            assertTrue(obj.has("id"),"no id");
            assertTrue(obj.has("versionId"),"no versionId");
            assertTrue(obj.has("name"),"no name");
        }
    }

    public static void getBidSheetBillGeoRegions(HttpClientResponse response,String proectId,String billVersionId){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray bidSheetBillGeoRegions = root.getAsJsonArray("bidSheetBillGeoRegions");
        Iterator<JsonElement> it = bidSheetBillGeoRegions.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("id"),"no id");
            assertEquals(obj.get("projectId").getAsString(),proectId,"no projectId");
            assertEquals(obj.get("versionId").getAsString(),billVersionId,"no versionId");
            assertTrue(obj.has("geoRegion"),"no geoRegion");
            assertTrue(obj.has("createTimestamp"),"no createTimestamp");
        }
    }

    public static void getBidSheetBillSubParts(HttpClientResponse response,String proectId,String billVersionId){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray bidSheetBillGeoRegions = root.getAsJsonArray("bidSheetBillSubParts");
        Iterator<JsonElement> it = bidSheetBillGeoRegions.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("id"),"no id");
            assertEquals(obj.get("projectId").getAsString(),proectId,"no projectId");
            assertEquals(obj.get("versionId").getAsString(),billVersionId,"no versionId");
            assertTrue(obj.has("subPart"),"no subPart");
            assertTrue(obj.has("createTimestamp"),"no createTimestamp");
        }
    }

    public static void getAllBidSheetBillInfo(HttpClientResponse response,String billVersionId){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray obidSheetBillInfos = root.getAsJsonArray("obidSheetBillInfos");
        Iterator<JsonElement> it = obidSheetBillInfos.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("bidSheetBillInfoId"),"no bidSheetBillInfoId");
            assertEquals(obj.get("versionId").getAsString(),billVersionId,"versionId error");
            assertTrue(obj.has("elementIds"),"no elementIds");
            assertTrue(obj.has("name"),"no name");
            assertTrue(obj.has("encoding"),"no encoding");
            assertTrue(obj.has("billDetailSN"),"no billDetailSN");
            assertTrue(obj.has("billDetailId"),"no billDetailId");
            assertTrue(obj.has("billTrait"),"no billTrait");
            assertTrue(obj.has("geoRegion"),"no geoRegion");
            assertTrue(obj.has("subPart"),"no subPart");
            assertTrue(obj.has("unit"),"no unit");
            assertTrue(obj.has("bidSheetQuantities"),"no bidSheetQuantities");
            assertTrue(obj.has("bidSheetQuotaInfos"),"no bidSheetQuotaInfos");
            assertTrue(obj.has("replacementName"),"no replacementName");
            assertTrue(obj.has("modelQuantity"),"no modelQuantity");
            assertTrue(obj.has("customizedModelBillInfo"),"no customizedModelBillInfo");
            assertTrue(obj.has("timestamp"),"no timestamp");
        }
    }
}
