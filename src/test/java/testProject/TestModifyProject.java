package testProject;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertProject;
import com.decobim.services.main.project.GetProject;
import com.decobim.services.main.project.ModifyProject;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/11.
 */
public class TestModifyProject {
    private ModifyProject modifyProject = new ModifyProject();
    private GetProject getProject = new GetProject();
    private User user = User.user7();
    private Project before = Project.jingjiLake();
    private Project after = Project.yinjiLake();

    @Test(description = "修改前查看项目内容")
    public void testModifyProject01() throws Exception {
        HttpClientResponse response = getProject.getProject(user,before);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertProject.getProject(response,before);
    }

    @Test(description = "修改项目信息")
    public void testModifyProject02() throws Exception {
        HttpClientResponse response = modifyProject.modifyProect(user,before,after);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertProject.modifyProject(response,after);
    }

    @Test(description = "修改后查看项目信息")
    public void testModifyProject03() throws Exception {
        HttpClientResponse response = getProject.getProject(user,after);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertProject.getProject(response,after);
    }
}
