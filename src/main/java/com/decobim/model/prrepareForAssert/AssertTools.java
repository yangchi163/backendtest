package com.decobim.model.prrepareForAssert;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 2017/8/15.
 */
public class AssertTools {
    //验证模型树的结构是否正确
    public static boolean verifyModelTree(JsonObject jsonObject){
        Assert.assertNotEquals(jsonObject.get("key").toString(),"null");
        Assert.assertNotEquals(jsonObject.get("title").toString(),"null");
        Assert.assertEquals(jsonObject.get("children").isJsonArray(),true);
        JsonArray children = jsonObject.getAsJsonArray("children");
        if (children.size() > 0){
            Iterator<JsonElement> it = children.iterator();
            while (it.hasNext()){
                JsonObject obj = (JsonObject) it.next();
                verifyModelTree(obj);
            }
        }
        return true;
    }
    //验证一个String是否在list中
    public static boolean stringInList(String s,List<String> list){
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String sInList = it.next();
            if (s.equals(sInList)){
                return true;
            }
        }
        return false;
    }
    //验证2个list是否相等
    /*public static boolean listEqualsList(List<String> a,List<String> b){
        try {
            if (a.size() != b.size()){
                return false;
            }
            Iterator<String> it = a.iterator();
            while (it.hasNext()){
                String s = it.next();
                assertTrue(stringInList(s,b));
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }*/
    //验证jsonarray中的元素与list中的元素相同(都是string)
    public static boolean jsonArrayEqualsList(JsonArray a, List<String> b){
        try {
            if (a.size() != b.size()){
                return false;
            }
            Gson gson = new Gson();
            List<String> s = new ArrayList<>();
            s = gson.fromJson(a,s.getClass());
            assertTrue(listEqualsList(s,b));
            return true;
        }catch (Exception e){
            return false;
        }

    }
    //验证一个元素是否在list中
    public static<T> boolean elementInList(T t,List<T> list){
        boolean flag = false;
        for (T t1 : list){
            if (t.equals(t1)){
                flag = true;
                return flag;
            }
        }
        return  flag;
    }
    //验证2个list是否相同(元素重复时会出错)
    public static <T> boolean listEqualsList(List<T> list1,List<T> list2){
        boolean flag = false;
        if(list1.size() != list2.size()){
            System.out.println("size不一样");
            return flag;
        }
        for (T t : list1){
            if(!elementInList(t,list2)){
                return flag;
            }
        }
        for (T t : list2){
            if (!elementInList(t,list1)){
                return flag;
            }
        }
        return !flag;
    }
}
