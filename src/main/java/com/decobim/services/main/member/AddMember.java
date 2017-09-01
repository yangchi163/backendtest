package com.decobim.services.main.member;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.http.HttpHeadersKey;
import com.decobim.model.prepareForTest.Member;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.MemberModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;


/**
 * 添加项目成员
 * http://test.api.decobim.com/v1/projects/1/members
 * post
 * Created by Administrator on 2017/8/15.
 */
public class AddMember extends Base {
    public AddMember() {
    }

    public HttpClientResponse addMember(User user, Project project,Member addMember) throws Exception {
        return addMember(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),addMember);
    }

    public HttpClientResponse addMember(String token, String roleId, String projectId, Member addMember) throws Exception {
        String url = uriBuilder
                .setPath(MemberModule.addMember(projectId))
                .build()
                .toString();
        request.setHeaders(token,roleId);
        request.setBody(gson.toJson(addMember));
        request.setUrl(url);
        //System.out.println(request);
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
