package testProject;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertProject;
import com.decobim.services.main.project.AddMeasurementInfo;
import com.decobim.services.main.project.CreateProject;
import com.decobim.services.main.project.GetProject;
import com.decobim.services.main.project.ProjectLists;
import com.decobim.utils.Tools;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/10.
 */
public class TestCreateProject {
    private ProjectLists projectLists = new ProjectLists();
    private CreateProject createProject = new CreateProject();
    private GetProject getProject = new GetProject();
    private AddMeasurementInfo addMeasurementInfo = new AddMeasurementInfo();
    private Project project = Project.jingjiLake();
    private User user = User.user6();

    @Test(description = "项目列表为0")
    public void testCreateProject01() throws Exception {
        System.out.println("testCreateProject01");
        HttpClientResponse response = projectLists.projectLists(user);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertCommon.assertPaging(response,"1","10000","0");
        AssertProject.projectLists(response,"0");
    }

    @Test(description = "创建项目")
    public void testCreateProject02() throws Exception {
        System.out.println("testCreateProject02");
        HttpClientResponse response = createProject.createProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertProject.createProject(response,project);
    }

    @Test(description = "项目列表为1个项目")
    public void testCreateProject03() throws Exception {
        System.out.println("testCreateProject03");
        HttpClientResponse response = projectLists.projectLists(user);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertCommon.assertPaging(response,"1","10000","1");
        AssertProject.projectLists(response,"1");
    }

    @Test(description = "查看项目")
    public void testCreateProject04() throws Exception {
        System.out.println("testCreateProject04");
        HttpClientResponse response = getProject.getProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertProject.getProject(response,project);
    }

    @Test(description = "修改项目项目清单库版本信息和定额库版本信息")
    public void testCreateProject05() throws Exception {
        System.out.println("testCreateProject05");
        HttpClientResponse response = addMeasurementInfo.addMeasurementInfo(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertProject.addMeasurementInfo(response,project, Tools.getMeasurementBillDbVersionId(user),
                Tools.getMeasurementQuotaDbVersionId(user));
    }
}
