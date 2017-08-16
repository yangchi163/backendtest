package com.decobim.utils;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Auth;
import com.decobim.services.main.measurement.GetDbVersionInfo;
import com.decobim.services.main.member.GetMemberListOfProject;
import com.decobim.services.main.member.GetRoleListOfSbInProject;
import com.decobim.services.main.project.ProjectLists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Iterator;

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
        System.out.println(object);
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

    public static String getRoleId(User user,Project project) throws Exception {
        String roleId = null;
        ProjectLists projectLists = new ProjectLists();
        HttpClientResponse response = projectLists.projectLists(user);
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray list = root.getAsJsonArray("list");
        Iterator<JsonElement> it = list.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            if (obj.get("name").getAsString().equals(project.getName())){
                JsonArray roles = obj.getAsJsonArray("roles");
                assertTrue(roles.size() > 0 ,"has no role");
                JsonObject obj2 = (JsonObject) roles.get(0);
                roleId = obj2.get("roleId").getAsString();
                return roleId;
            }
        }
        return roleId;
    }

    public static String getProjectId(User user,Project project) throws Exception {
        String projectId = null;
        ProjectLists projectLists = new ProjectLists();
        HttpClientResponse response = projectLists.projectLists(user);
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        assertTrue(root.has("list"),"no list");
        JsonArray list = root.getAsJsonArray("list");
        Iterator<JsonElement> it = list.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("name"),"no name");
            if (obj.get("name").getAsString().equals(project.getName())){
                projectId = obj.get("projectId").getAsString();
                return projectId;
            }
        }
        return projectId;
    }

    public static String getMeasurementBillDbVersionId(User user) throws Exception {
        String measurementBillDbVersionId ;
        GetDbVersionInfo getDbVersionInfo = new GetDbVersionInfo();
        HttpClientResponse response = getDbVersionInfo.getDbVersionInfo(user);
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray billDbVersions = root.getAsJsonArray("billDbVersions");
        assertTrue(billDbVersions.size() > 0, "没有清单库");
        JsonObject obj = (JsonObject) billDbVersions.get(0);
        measurementBillDbVersionId = obj.get("id").getAsString();
        return measurementBillDbVersionId;
    }

    public static String getMeasurementQuotaDbVersionId(User user) throws Exception {
        String measurementQuotaDbVersionId = null;
        GetDbVersionInfo getDbVersionInfo = new GetDbVersionInfo();
        HttpClientResponse response = getDbVersionInfo.getDbVersionInfo(user);
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray quotaDbVersions = root.getAsJsonArray("quotaDbVersions");
        assertTrue(quotaDbVersions.size() > 0, "没有清单库");
        JsonObject obj = (JsonObject) quotaDbVersions.get(0);
        measurementQuotaDbVersionId = obj.get("id").getAsString();
        return measurementQuotaDbVersionId;
    }

    public static String getMemberId(User user,Project project) throws Exception {
        String memberId = null;
        GetMemberListOfProject getMemberListOfProject = new GetMemberListOfProject();
        HttpClientResponse response = getMemberListOfProject.getMemberListOfProject(user,project);
        JsonArray root = (JsonArray) parser.parse(response.getBody());
        Iterator<JsonElement> it = root.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            if (obj.get("userId").getAsString().equals(getUserId(user))){
                memberId = obj.get("memberId").getAsString();
                return memberId;
            }
        }
        return memberId;
    }

}
