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
 * 删除项目成员
 * http://test.api.decobim.com/v1/projects/2/members/1
 * delete
 * Created by Administrator on 2017/8/15.
 */
public class DeleteMember extends Base {
    public DeleteMember() {
    }

    public HttpClientResponse deleteMember(User user, Project project,User deleteMember) throws Exception {
        return deleteMember(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),Tools.getMemberId(deleteMember,project));
    }

    public HttpClientResponse deleteMember(String token,String roleId,String projectId,String memberId) throws Exception {
        String url = uriBuilder
                .setPath(MemberModule.deleteMember(projectId,memberId))
                .build()
                .toString();
        request.getHeaders().put(HttpHeadersKey.AUTHORIZATION,token);
        request.getHeaders().put(HttpHeadersKey.ROLEID,roleId);
        request.setUrl(url);
        return HttpClientUtil.doDelete(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
