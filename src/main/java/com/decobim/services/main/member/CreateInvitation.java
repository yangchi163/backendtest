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
 * 创建邀请
 * http://test.api.decobim.com/v1/project/{projectId}/invitations
 * post
 * Created by Administrator on 2017/8/15.
 */
public class CreateInvitation extends Base {
    public CreateInvitation() {
    }

    public HttpClientResponse createInvitation(User user, Project project, Member member) throws Exception {
        return createInvitation(Tools.getAuth(user),Tools.getRoleId(user,project),member);
    }
    public HttpClientResponse createInvitation(String token, String roleId, Member member) throws Exception {
        String url = uriBuilder
                .setPath(MemberModule.createInvitation(member.getProjectId()))
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        request.setUrl(url);
        request.setBody(gson.toJson(member));
        //System.out.println("request:" + request);
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
