package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.google.gson.JsonObject;
import static org.testng.Assert.*;

/**
 * 验证状态码
 * 验证错误信息
 * 验证通用的一些格式等
 * Created by Administrator on 2017/8/9.
 */
public class AssertCommon extends AssertBase {
    //验证状态码
    public static void statusCode(HttpClientResponse response, String expected) {
        String actual = response.getStatusCode();
        assertEquals(actual, expected, "状态码错误");
    }

    //验证返回的错误信息
    public static void returnException(HttpClientResponse response, String message, String code) {
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertEquals(object.get("message").getAsString(), message, "message异常");
        assertEquals(object.get("code").getAsString(), code, "code异常");
        assertTrue(object.has("extra"),"no extra");
    }

    public static void returnException(HttpClientResponse response) {
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertTrue(object.has("message"),"no message");
        assertTrue(object.has("code"),"no code");
        assertTrue(object.has("extra"),"no extra");
    }

    //验证未鉴权
    public static void unAuthorized(HttpClientResponse response){
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertEquals(object.get("status").getAsString(), StatusCode.UNAUTHORIZED,"UNAUTHORIZED");
    }

    //验证分页格式
    public static void assertPaging(HttpClientResponse response, String pageNum, String pageSize,String total) {
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        assertEquals(root.get("pageNum").getAsString(),pageNum,"pageNum错误");
        assertEquals(root.get("pageSize").getAsString(),pageSize,"pageSize错误");
        assertEquals(root.get("total").getAsString(),total,"total错误");
        assertEquals(root.get("pages").getAsInt(),(int) Math.ceil(root.get("total").getAsDouble() / root.get("pageSize").getAsDouble()),"pages错误");
        if (root.get("pageNum").getAsInt() < root.get("pages").getAsInt()) {
            assertEquals(root.get("size").getAsInt(), root.get("pageSize").getAsInt(),"size错误");
        } else if(root.get("pageNum").getAsInt() == root.get("pages").getAsInt()){
            assertEquals(root.get("size").getAsInt(),root.get("total").getAsInt()-(root.get("pages").getAsInt()-1)* root.get("pageSize").getAsInt(),"size错误");
        }else {
            assertEquals(root.get("size").getAsInt(),0,"size错误");
        }
    }

}
