package testProject;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertProject;
import com.decobim.services.main.project.CreateProject;
import com.decobim.services.main.project.ProjectLists;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/10.
 */
public class TestCreateProject {
    private ProjectLists projectLists = new ProjectLists();
    private CreateProject createProject = new CreateProject();
    private Project project = Project.jingjiLake();
    private User user = User.user6();

    @Test(description = "项目列表为0")
    public void testCreateProject01() throws Exception {
        HttpClientResponse response = projectLists.projectLists(user);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertCommon.assertPaging(response,"1","10000","0");
        AssertProject.projectLists(response,"0");
    }

    @Test(description = "创建项目")
    public void testCreateProject02() throws Exception {
        HttpClientResponse response = createProject.createProject(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertProject.createProject(response,project);
    }

    @Test(description = "项目列表为1个项目")
    public void testCreateProject03() throws Exception {
        HttpClientResponse response = projectLists.projectLists(user);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertCommon.assertPaging(response,"1","10000","1");
        AssertProject.projectLists(response,"1");
    }
}
