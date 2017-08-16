package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Member;
import com.decobim.model.prepareForTest.Role;
import com.decobim.model.prrepareForAssert.AssertTools;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Administrator on 2017/8/15.
 */
public class AssertMember extends AssertBase {

    public static void getMemberListOfProject(HttpClientResponse response,String total){
        JsonArray root = (JsonArray) parser.parse(response.getBody());
        assertEquals(root.size(),Integer.parseInt(total),"list size error");
        Iterator<JsonElement> it = root.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("mobile"),"no mobile");
            assertTrue(obj.has("created"),"no created");
            assertTrue(obj.has("status"),"no status");
            assertTrue(obj.has("userId"),"no userId");
            assertTrue(obj.has("name"),"no name");
            assertTrue(obj.has("avatarUrl"),"no avatarUrl");
            assertTrue(obj.has("roleId"),"no roleId");
            assertTrue(obj.has("roleName"),"no roleName");
            assertTrue(obj.has("scope"),"no scope");
            assertTrue(obj.has("remark"),"no remark");
            assertTrue(obj.has("memberId"),"no memberId");
        }
    }

    public static void getRoleListOfSbInProject(HttpClientResponse response, List<Role> list){
        Gson gson = new Gson();
        List<Role> roles = gson.fromJson(response.getBody(), new TypeToken<List<Role>>(){}.getType());
        assertTrue(AssertTools.listEqualsList(roles,list));
    }

    public static void addMember(HttpClientResponse response, Member member){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        assertTrue(root.has("memberId"),"no memberId");
        assertEquals(root.get("projectId").getAsString(),member.getProjectId(),"projectId error");
        assertTrue(root.has("projectName"),"no projectName");
        assertEquals(root.get("remark").getAsString(),member.getRemark(),"remark error");
        assertEquals(root.get("roleId").getAsString(),member.getRoleId(),"roleId error");
        assertTrue(root.has("roleName"),"no roleName");
        assertEquals(root.get("scope").getAsString(),member.getScope(),"scope error");
        assertEquals(root.get("userId").getAsString(),member.getUserId(),"userId error");
        assertTrue(root.has("userName"),"no userName");
    }

    public static void getRoleListOfProject(HttpClientResponse response,List<Role> list){
        Gson gson = new Gson();
        List<Role> roles = gson.fromJson(response.getBody(), new TypeToken<List<Role>>(){}.getType());
        assertTrue(AssertTools.listEqualsList(roles,list));
    }

    public static void createInvitation(HttpClientResponse response,Member member){
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        assertTrue(root.has("created"),"no created");
        assertTrue(root.has("invitationId"),"no invitationId");
        assertEquals(root.get("mobile").getAsString(),member.getMobile(),"mobile error");
        assertEquals(root.get("projectId").getAsString(),member.getProjectId(),"projectId error");
        assertEquals(root.get("remark").getAsString(),member.getRemark(),"remark error");
        assertEquals(root.get("roleId").getAsString(),member.getRoleId(),"roleId error");
        assertEquals(root.get("scope").getAsString(),member.getScope(),"scope error");
    }

}
