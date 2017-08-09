package com.decobim.services.assertResult;

import com.decobim.model.prrepareForAssert.RecordStatus;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.http.HttpClientResponse;
import com.google.gson.JsonObject;
import static org.testng.Assert.*;
/**
 * Created by Administrator on 2017/8/9.
 */
public class AssertIdentity extends AssertBase{
    public static void registry(HttpClientResponse response, User user){
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertEquals(object.get("mobile").getAsString(),user.getUserName(),"手机号不对");
        assertEquals(object.get("name").getAsString(),user.getUserName(),"name不对");
        assertEquals(object.get("status").getAsString(), RecordStatus.NORMAL,"status不对");
        assertTrue(object.has("userId"),"没有userId");
        assertTrue(object.has("avatarUrl"),"没有avatarUrl");
        assertTrue(object.has("pfileId"),"没有pfileId");
    }

    public static void auth(HttpClientResponse response){
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertTrue(object.has("token"),"no token");
        assertTrue(object.has("userId"),"no userId");
    }
}
