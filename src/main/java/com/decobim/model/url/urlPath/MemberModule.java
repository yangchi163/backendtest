package com.decobim.model.url.urlPath;
import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/8/10.
 */
public class MemberModule {

    public static String getRoleListOfSbInProject(String userId,String projectId){
        String url = "/v1/users/{0}/projects/{1}/roles";
        url = MessageFormat.format(url,userId,projectId);
        return url;
    }

    public static String getMemberListOfProject(String projectId){
        String url = "/v1/projects/{0}/members";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String addMember(String projectId){
        String url = "/v1/projects/{0}/members";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String deleteMember(String projectId,String memberId){
        String url = "/v1/projects/{0}/members/{1}";
        url = MessageFormat.format(url,projectId,memberId);
        return url;
    }

    public static String getRoleListOfProject(String projectId){
        String url = "/v1/projects/{0}/roles";
        url = MessageFormat.format(url,projectId);
        return url;
    }

    public static String createInvitation(String projectId){
        String url = "/v1/project/{0}/invitations";
        url = MessageFormat.format(url,projectId);
        return url;
    }
}
