package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

import static org.testng.Assert.*;

/**
 * Created by Administrator on 2017/8/23.
 */
public class AssertBimModel extends AssertBase{

    public static void getModelTree(HttpClientResponse response){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        verifyModelTree(root);
    }

    private static void verifyModelTree(JsonObject jsonObject){
        assertTrue(jsonObject.has("key"),"no key");
        assertTrue(jsonObject.has("elementId"),"no elementId");
        assertTrue(jsonObject.has("title"),"no title");
        assertTrue(jsonObject.has("children"));
        JsonArray children = jsonObject.getAsJsonArray("children");
        if (children.size()>0){
            Iterator<JsonElement> it = children.iterator();
            while (it.hasNext()){
                JsonObject obj = (JsonObject) it.next();
                verifyModelTree(obj);
            }
        }
    }
}
