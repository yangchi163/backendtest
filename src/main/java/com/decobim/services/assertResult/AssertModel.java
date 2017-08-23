package com.decobim.services.assertResult;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.ModelView;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.RecordStatus;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.utils.Tools;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

import static org.testng.Assert.*;

/**
 * Created by Administrator on 2017/8/22.
 */
public class AssertModel extends AssertBase {

    public static void getModels(HttpClientResponse response, User user, Project project, int number) throws Exception {
        JsonArray root = (JsonArray) parser.parse(response.getBody());
        assertEquals(root.size(), number, "size 不对");
        Iterator<JsonElement> it = root.iterator();
        while (it.hasNext()) {
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("modelId"), "no modelId");
            assertTrue(obj.has("modelExtraId"), "no modelExtraId");
            assertTrue(obj.has("name"), "no name");
            assertTrue(obj.has("svfFileId"), "no svfFileId");
            assertTrue(obj.has("svfFileUri"), "no svfFileUri");
            assertTrue(obj.has("sdbFileId"), "no sdbFileId");
            assertTrue(obj.has("sdbFileUri"), "no sdbFileUri");
            assertTrue(obj.has("version"), "no version");
            assertTrue(obj.has("created"), "no created");
            assertTrue(obj.has("list"), "no list");
            assertEquals(obj.get("ownerId").getAsString(), Tools.getUserId(user), "ownerId error");
            assertEquals(obj.get("ownerName").getAsString(), user.getName(), "ownerName error");
            assertEquals(obj.get("projectId").getAsString(), Tools.getProjectId(user, project), "projectId error");
            assertEquals(obj.get("status").getAsString(), RecordStatus.NORMAL, "status error");
        }
    }

    public static void deleteModel(HttpClientResponse response){
        assertTrue(response.getBody().contains("OK"),"no ok in body");
    }

    public static void addModel(HttpClientResponse response, Model model, User user, Project project, int modelVersion) throws Exception {
        verifyModel(response.getBody(), model, user, project, modelVersion);
    }

    public static void getModel(HttpClientResponse response, Model model, User user, Project project, int modelVersion) throws Exception {
        verifyModel(response.getBody(), model, user, project, modelVersion);
    }

    private static void verifyModel(String json, Model model, User user, Project project, int modelVersion) throws Exception {
        JsonObject root = (JsonObject) parser.parse(json);
        assertEquals(root.get("modelId").getAsString(), model.getModelId(), "modelId error");
        assertEquals(root.get("modelExtraId").getAsString(), model.getModelExtraId(), "modelExtraId error");
        assertEquals(root.get("name").getAsString(), model.getName(), "name error");
        assertTrue(root.has("svfFileId"), "no svfFileId");
        assertTrue(root.has("svfFileUri"), "no svfFileUri");
        assertTrue(root.has("sdbFileId"), "no sdbFileId");
        assertTrue(root.has("sdbFileUri"), "no sdbFileUri");
        assertEquals(root.get("version").getAsInt(), modelVersion, "version error");
        assertEquals(root.get("ownerId").getAsString(), Tools.getUserId(user), "ownerId error");
        assertEquals(root.get("ownerName").getAsString(), user.getName(), "ownerName error");
        assertEquals(root.get("projectId").getAsString(), Tools.getProjectId(user, project), "projectId error");
        assertEquals(root.get("status").getAsString(), RecordStatus.NORMAL, "status error");
        assertTrue(root.has("created"), "no created");
    }

    public static void getModelViews(HttpClientResponse response,Model model,int number){
        JsonArray root = (JsonArray) parser.parse(response.getBody());
        assertEquals(root.size(),number,"size error");
        Iterator<JsonElement> it = root.iterator();
        while (it.hasNext()){
            JsonObject obj = (JsonObject) it.next();
            assertTrue(obj.has("created"),"no created");
            assertTrue(obj.has("modelViewId"),"no modelViewId");
            assertTrue(obj.has("name"),"no name");
            assertTrue(obj.has("state"),"no state");
            assertTrue(obj.has("thumbnailUrl"),"no thumbnailUrl");
            assertEquals(obj.get("projectId").getAsString(),model.getProjectId(),"projectId error");
            assertEquals(obj.get("modelId").getAsString(),model.getModelId(),"modelId error");
            assertEquals(obj.get("status").getAsString(),RecordStatus.NORMAL,"status error");
        }
    }

    public static void addModelView(HttpClientResponse response, ModelView modelView){
        verifyModelView(response.getBody(),modelView);
    }

    public static void getModelView(HttpClientResponse response,ModelView modelView){
        verifyModelView(response.getBody(),modelView);
    }

    private static void verifyModelView(String json,ModelView modelView){
        JsonObject root = (JsonObject) parser.parse(json);
        assertEquals(root.get("modelViewId").getAsString(),modelView.getModelViewId(),"modelViewId error");
        assertEquals(root.get("thumbnailUrl").getAsString(),modelView.getThumbnailUrl(),"thumbnailUrl error");
        assertEquals(root.get("state").getAsString(),modelView.getState(),"state error");
        assertEquals(root.get("name").getAsString(),modelView.getName(),"name error");
        assertEquals(root.get("status").getAsString(), RecordStatus.NORMAL,"status error");
        assertTrue(root.has("created"),"no created");
        assertEquals(root.get("projectId").getAsString(),modelView.getProjectId(),"projectId error");
        assertEquals(root.get("modelId").getAsString(),modelView.getModelId(),"modelId error");
    }

}
