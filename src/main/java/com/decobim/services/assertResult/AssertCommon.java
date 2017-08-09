package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.google.gson.JsonObject;

import static org.testng.Assert.*;
/**
 * 验证状态码
 * 验证错误信息
 * 验证通用的一些格式等
 * Created by Administrator on 2017/8/9.
 */
public class AssertCommon extends AssertBase{
    public static void statusCode(HttpClientResponse response,String expected){
        String actual = response.getStatusCode();
        assertEquals(actual,expected,"状态码错误");
    }
    public static void returnException(HttpClientResponse response,String message,String code){
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        assertEquals(object.get("message").getAsString(),message,"message异常");
        assertEquals(object.get("code").getAsString(),code,"code异常");
    }

}
