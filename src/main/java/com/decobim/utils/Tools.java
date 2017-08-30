package com.decobim.utils;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.*;
import com.decobim.services.main.identity.Auth;
import com.decobim.services.main.measurement.GetAllBidSheetBillInfo;
import com.decobim.services.main.measurement.GetBidBillVersionInfos;
import com.decobim.services.main.measurement.GetDbVersionInfo;
import com.decobim.services.main.member.GetMemberListOfProject;
import com.decobim.services.main.member.GetRoleListOfSbInProject;
import com.decobim.services.main.model.GetModelViews;
import com.decobim.services.main.model.GetModels;
import com.decobim.services.main.project.ProjectLists;
import com.decobim.services.main.role.GetRoleList;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;
/**
 * Created by Administrator on 2017/8/9.
 */
public class Tools {

    private static JsonParser parser = new JsonParser();

    //读取文件内容，返回字符串
    public static String getStringFromFile(String filePath) {
        StringBuffer result = new StringBuffer();
        BufferedReader bufferedReader = null;
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(filePath));
            bufferedReader = new BufferedReader(read);
            String lineTxt;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                result.append(lineTxt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    //将json串反序列化成model
    public static Model getModel(String filePath) {
        Gson gson = new Gson();
        Model model;
        model = gson.fromJson(getStringFromFile(filePath), Model.class);
        return model;
    }

    public static String getAuth(User user) throws Exception {
        String token = null;
        Auth auth = new Auth();
        HttpClientResponse response = auth.auth(user);
        JsonObject object = (JsonObject) parser.parse(response.getBody());
        //System.out.println(object);
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
    //查询用户的角色id
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
                assertTrue(roles.size() > 0 ,"has no testRole");
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
        JsonArray billDbVersions = root.getAsJsonArray("billVersions");
        assertTrue(billDbVersions.size() > 0, "没有清单库");
        JsonObject obj = (JsonObject) billDbVersions.get(0);
        measurementBillDbVersionId = obj.get("versionId").getAsString();
        return measurementBillDbVersionId;
    }

    public static String getMeasurementQuotaDbVersionId(User user) throws Exception {
        String measurementQuotaDbVersionId = null;
        GetDbVersionInfo getDbVersionInfo = new GetDbVersionInfo();
        HttpClientResponse response = getDbVersionInfo.getDbVersionInfo(user);
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray quotaDbVersions = root.getAsJsonArray("quotaVersions");
        assertTrue(quotaDbVersions.size() > 0, "没有清单库");
        JsonObject obj = (JsonObject) quotaDbVersions.get(0);
        measurementQuotaDbVersionId = obj.get("versionId").getAsString();
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
    //根据角色名查询roleId
    public static String getRoleId (User user, Role role) throws Exception {
        String roleId = null;
        GetRoleList getRoleList = new GetRoleList();
        HttpClientResponse response = getRoleList.getRoleList(getAuth(user),"1","10000");
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray list = root.getAsJsonArray("list");
        Iterator<JsonElement> it = list.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            if(role.getName().equals(obj.get("name").getAsString())){
                roleId = obj.get("roleId").getAsString();
                return roleId;
            }
        }
        return roleId;
    }

    public static String getModelId (User user,Project project,Model model) throws Exception {
        String modelId = null;
        GetModels getModels = new GetModels();
        HttpClientResponse response = getModels.getModels(user,project);
        JsonArray root = (JsonArray) parser.parse(response.getBody());
        Iterator<JsonElement> it = root.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            if(model.getModelExtraId().equals(obj.get("modelExtraId").getAsString())){
                modelId = obj.get("modelId").getAsString();
                return modelId;
            }
        }
        return modelId;
    }

    public static String getModelViewId(User user, Project project, Model model, ModelView modelView) throws Exception {
        String modelViewId = null;
        GetModelViews getModelViews = new GetModelViews();
        HttpClientResponse response = getModelViews.getModelViews(user,project,model);
        JsonArray root = (JsonArray) parser.parse(response.getBody());
        Iterator<JsonElement> it = root.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            if(modelView.getName().equals(obj.get("name").getAsString())){
                modelViewId = obj.get("modelViewId").getAsString();
                return modelViewId;
            }
        }
        return modelViewId;
    }

    public static String getBillVersionId(User user,Project project) throws Exception {
        String billId = null;
        long timestamp = 0;
        GetBidBillVersionInfos getBidBillVersionInfos = new GetBidBillVersionInfos();
        HttpClientResponse response = getBidBillVersionInfos.getBidBillVersionInfos(user, project);
        JsonParser parser = new JsonParser();
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray versionInfos = root.getAsJsonArray("versionInfos");
        Iterator<JsonElement> it = versionInfos.iterator();
        while (it.hasNext()) {
            JsonObject obj = (JsonObject) it.next();
            if (obj.get("timestamp").getAsLong() > timestamp) {
                billId = obj.get("versionId").getAsString();
            }
        }
        return billId;
    }

    //获取清单明细id列表
    public static List<String> getBidSheetBillInfoIds(User user, Project project) throws Exception {
        List<String> bidSheetBillInfoIds = new ArrayList<>();
        int i = 0;
        GetAllBidSheetBillInfo getAllBidSheetBillInfo = new GetAllBidSheetBillInfo();
        HttpClientResponse response = getAllBidSheetBillInfo.getAllBidSheetBillInfo(user, project);
        JsonObject root = (JsonObject) parser.parse(response.getBody());
        JsonArray obidSheetBillInfos = root.getAsJsonArray("obidSheetBillInfos");
        Iterator<JsonElement> it = obidSheetBillInfos.iterator();
        while (it.hasNext()) {
            if (i > 2) {
                return bidSheetBillInfoIds;
            }
            JsonObject obj = (JsonObject) it.next();
            bidSheetBillInfoIds.add(obj.get("bidSheetBillInfoId").getAsString());
            i++;
        }
        return bidSheetBillInfoIds;
    }

}
