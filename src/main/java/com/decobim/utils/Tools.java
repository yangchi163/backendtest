package com.decobim.utils;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Auth;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static org.testng.Assert.*;
/**
 * Created by Administrator on 2017/8/9.
 */
public class Tools {
    private static JsonParser parser = new JsonParser();
    public static String getAuth(User user) throws Exception {
        String token = null;
        Auth auth = new Auth();
        HttpClientResponse response = auth.auth(user);
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertTrue(object.has("token"),"no token");
        token = object.get("token").getAsString();
        return token;
    }

    public static String getUserId(User user) throws Exception {
        String userId = null;
        Auth auth = new Auth();
        HttpClientResponse response = auth.auth(user);
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertTrue(object.has("userId"),"no userId");
        userId = object.get("userId").getAsString();
        return userId;
    }
}
