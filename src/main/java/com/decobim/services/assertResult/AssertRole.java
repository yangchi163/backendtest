package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Role;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;
import static org.testng.Assert.*;
/**
 * Created by Administrator on 2017/8/16.
 */
public class AssertRole extends AssertBase{

    public static void getRoleList(HttpClientResponse response,String total){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray list = root.getAsJsonArray("list");
        assertEquals(list.size(),Integer.parseInt(total),"size error");
        Iterator<JsonElement> it = list.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("name"),"no name");
            assertTrue(obj.has("roleId"),"no roleId");
        }
    }

    public static void modifyRole(HttpClientResponse response,Role role){
        verifyRole(response.getBody(),role);
    }

    public static void addRole(HttpClientResponse response, Role role){
        verifyRole(response.getBody(),role);
    }

    public static void getRole(HttpClientResponse response,Role role){
        verifyRole(response.getBody(),role);
    }

    private static void verifyRole(String jsonRole,Role role){
        JsonObject root = (JsonObject) parser.parse(jsonRole);
        assertEquals(root.get("name").getAsString(),role.getName(),"name error");
        assertEquals(root.get("roleId").getAsString(),role.getRoleId(),"roleId error");
    }
}
