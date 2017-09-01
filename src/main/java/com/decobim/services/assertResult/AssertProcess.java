package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Process;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

import static org.testng.Assert.*;
/**
 * Created by Administrator on 2017/8/31.
 */
public class AssertProcess extends AssertBase {

    public static int getProcess(HttpClientResponse response,int processNumber){
        JsonArray root = (JsonArray) parser.parse(response.getBody());
        if (processNumber != 0){
            assertEquals(root.size(),processNumber,"size error");
            Iterator<JsonElement> it = root.iterator();
            while (it.hasNext()){
                JsonObject obj = (JsonObject) it.next();
                assertTrue(obj.has("processId"),"no processId");
                assertTrue(obj.has("orderId"),"no orderId");
                assertTrue(obj.has("billId"),"no billId");
                assertTrue(obj.has("name"),"no name");
            }
        }
        return root.size();
    }

    public static void addProcess(HttpClientResponse response,Process process){
        verifyProcess(response.getBody(),process);
    }

    private static void verifyProcess(String json, Process process){
        JsonObject root = (JsonObject) parser.parse(json);
        assertTrue(root.has("processId"),"no processId");
        assertEquals(root.get("orderId").getAsString(),process.getOrderId(),"orderId error");
        assertEquals(root.get("billId").getAsString(),process.getBillId(),"billId error");
        assertEquals(root.get("name").getAsString(),process.getName(),"name error");
    }
}
