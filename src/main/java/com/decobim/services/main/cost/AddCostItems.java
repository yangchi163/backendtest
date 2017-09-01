package com.decobim.services.main.cost;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.CostItems;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.url.urlPath.CostModule;
import com.decobim.services.main.Base;
import com.decobim.utils.Tools;
import com.decobim.utils.http.HttpClientUtil;

/**
 * 新增成本拆分项
 * http://test.api.decobim.com/v1/projects/1/cost-items
 * Created by Administrator on 2017/8/31.
 */
public class AddCostItems extends Base {
    public AddCostItems() {
    }

    public HttpClientResponse addCostItems(User user, Project project,CostItems costItems) throws Exception {
        return addCostItems(Tools.getAuth(user),Tools.getRoleId(user,project),Tools.getProjectId(user,project),costItems);
    }

    public HttpClientResponse addCostItems(String token, String roleId, String projectId,CostItems costItems) throws Exception {
        String url = uriBuilder
                .setPath(CostModule.AddCostItems(projectId))
                .build()
                .toString();
        request.setHeaders(token,roleId);
        request.setUrl(url);
        request.setBody(gson.toJson(costItems));
        return HttpClientUtil.doPost(request,Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
