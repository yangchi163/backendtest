package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.RecordStatus;
import com.decobim.utils.Tools;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by jtl on 2017/8/10.
 */
public class AssertUser extends AssertBase {
    public static void getCurrentUser(HttpClientResponse response, User user)throws Exception{
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertEquals(object.get("mobile").getAsString(),user.getUserName());
        assertTrue(object.has("created"));
        assertEquals(object.get("status").getAsString(), RecordStatus.NORMAL);
        assertTrue(object.has("userId"));
        assertEquals(object.get("name").getAsString(),user.getName());
        assertTrue(object.has("avatarUrl"));
    }

    public static void getUsers(HttpClientResponse response)throws Exception{
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertTrue(object.get("pageNum").getAsInt() >= 0);
        assertTrue(object.get("pageSize").getAsInt() >= 0);
        assertTrue(object.get("size").getAsInt() >= 0);
        assertTrue(object.get("total").getAsInt() >= 0);
        assertTrue(object.get("pages").getAsInt() >= 1);
        JsonArray list = object.getAsJsonArray("list");
        assertTrue(object.get("pages")
                .getAsInt() == (int) Math.ceil(object.get("total").getAsDouble() / object.get("pageSize").getAsDouble()));
        if (object.get("pageNum").getAsInt() > object.get("pages").getAsInt()) {
            assertTrue(list.size() == 0);
        } else {
            assertTrue(list.size() == object.get("size").getAsInt());
            Iterator<JsonElement> it = list.iterator();
            while (it.hasNext()){
                JsonObject obj = (JsonObject)it.next();
                assertTrue(obj.has("mobile"));
                assertTrue(obj.has("created"));
                assertEquals(obj.get("status").getAsString(), RecordStatus.NORMAL);
                assertTrue(obj.has("userId"));
                assertTrue(obj.has("name"));
                assertTrue(obj.has("avatarUrl"));
            }
        }
    }
}
