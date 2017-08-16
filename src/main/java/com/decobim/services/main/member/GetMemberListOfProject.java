package com.decobim.services.main.member;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MemberModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;


/**
 * 项目成员列表
 * http://test.api.decobim.com/v1/projects/1/members?search=ww
 * get
 * Created by Administrator on 2017/8/15.
 */
public class GetMemberListOfProject extends Base{
    public GetMemberListOfProject() {
    }

    public HttpClientResponse getMemberListOfProject(User user,Project project) throws Exception {
        return getMemberListOfProject(user,project,null);
    }

    public HttpClientResponse getMemberListOfProject(User user, Project project,String search) throws Exception {
        return getMemberListOfProject(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),search);
    }

    public HttpClientResponse getMemberListOfProject(String token,String roleId,String projectId,String search) throws Exception {
        if (search != null){
            uriBuilder.setParameter("search",search);
        }
        String url = uriBuilder
                .setPath(MemberModule.getMemberListOfProject(projectId))
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        request.setUrl(url);
        return HttpClientUtil.doGet(request);
    }
}
