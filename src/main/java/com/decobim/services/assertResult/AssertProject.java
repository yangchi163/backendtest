package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Project;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

import static org.testng.Assert.*;
/**
 * Created by Administrator on 2017/8/10.
 */
public class AssertProject extends AssertBase {

    public static void projectLists(HttpClientResponse response,String total){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        assertTrue(root.has("list"),"no list");
        JsonArray list = root.getAsJsonArray("list");
        assertEquals(list.size(),Integer.parseInt(total),"list size 错误");
        Iterator<JsonElement> it = list.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("address"),"no address");
            assertTrue(obj.has("area"),"no area");
            assertTrue(obj.has("builder"),"no builder");
            assertTrue(obj.has("buildingType"),"no buildingType");
            assertTrue(obj.has("city"),"no city");
            assertTrue(obj.has("code"),"no code");
            assertTrue(obj.has("created"),"no created");
            assertTrue(obj.has("decorator"),"no decorator");
            assertTrue(obj.has("designer"),"no designer");
            assertTrue(obj.has("district"),"no district");
            assertTrue(obj.has("measurementBillDbVersionId"),"no measurementBillDbVersionId");
            assertTrue(obj.has("measurementQuotaDbVersionId"),"no measurementQuotaDbVersionId");
            assertTrue(obj.has("name"),"no name");
            assertTrue(obj.has("progress"),"no progress");
            assertTrue(obj.has("projectId"),"no projectId");
            assertTrue(obj.has("province"),"no province");
            assertTrue(obj.has("remark"),"no remark");
            assertTrue(obj.has("roles"),"no roles");
        }
    }

    public static void createProject(HttpClientResponse response,Project project){
        verifyProject(response.getBody(),project);
    }

    private static void verifyProject(String json, Project project){
        JsonObject root = (JsonObject) parser.parse(json);
        assertEquals(root.get("address").getAsString(),project.getAddress(),"address 错误");
        assertEquals(root.get("area").getAsDouble(),Double.parseDouble(project.getArea()),"area 错误");
        assertEquals(root.get("builder").getAsString(),project.getBuilder(),"builder 错误");
        assertEquals(root.get("buildingType").getAsString(),project.getBuildingType(),"buildingType 错误");
        assertEquals(root.get("city").getAsString(),project.getCity(),"city 错误");
        assertEquals(root.get("code").getAsString(),project.getCode(),"code 错误");
        assertTrue(root.has("created"),"no created");
        assertEquals(root.get("decorator").getAsString(),project.getDecorator(),"decorator 错误");
        assertEquals(root.get("designer").getAsString(),project.getDesigner(),"designer 错误");
        assertEquals(root.get("district").getAsString(),project.getDistrict(),"district 错误");
        assertTrue(root.has("measurementBillDbVersionId"),"no measurementBillDbVersionId");
        assertTrue(root.has("measurementQuotaDbVersionId"),"no measurementQuotaDbVersionId");
        assertEquals(root.get("name").getAsString(),project.getName(),"name 错误");
        assertEquals(root.get("progress").getAsString(),project.getProgress(),"progress 错误");
        assertTrue(root.has("projectId"),"no projectId");
        assertEquals(root.get("province").getAsString(),project.getProvince(),"province 错误");
        assertEquals(root.get("remark").getAsString(),project.getRemark(),"remark 错误");
    }
}
