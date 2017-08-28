package testModel;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.ResultCode;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertModel;
import com.decobim.services.main.model.AddModel;
import com.decobim.services.main.model.DeleteModel;
import com.decobim.services.main.model.GetModel;
import com.decobim.services.main.model.GetModels;
import com.decobim.utils.Tools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import start.Start;

/**
 * Created by Administrator on 2017/8/22.
 */
public class TestAddModel {
    private GetModels getModels = new GetModels();
    private AddModel addModel = new AddModel();
    private DeleteModel deleteModel = new DeleteModel();
    private GetModel getModel = new GetModel();
    private User user = User.user20();
    private Project project = Project.jingjiLake();
    private Model room1;
    private Model room2;
    private int room1ModelVersion = 1;
    private int room2ModelVersion = 1;
    private int modelNumber = 1;

    @Test(description = "得到项目的模型视图列表，没有")
    public void testAddModel01() throws Exception {
        HttpClientResponse response = getModels.getModels(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.PARAMETERERROR);
        AssertCommon.returnException(response,"查询失败：模型数据不存在或模型数据出现异常", ResultCode.ERROR_INVALID_PARAMTER);
    }

    @Test(description = "新增模型")
    public void testAddModel02() throws Exception {
        HttpClientResponse response = addModel.addModel(user,project,room1);
        System.out.println(response);
        //给模型设置modelId
        room1.setModelId(Tools.getModelId(user,project,room1));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.addModel(response,room1,user,project,room1ModelVersion);
    }

    @Test(description = "得到项目的模型视图列表，1个")
    public void testAddModel03() throws Exception {
        HttpClientResponse response = getModels.getModels(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.getModels(response,user,project,modelNumber);
    }

    @Test(description = "查看模型信息")
    public void testAddModel04() throws Exception {
        HttpClientResponse response = getModel.getModel(user,project,room1);
        System.out.println(response);
        //给模型设置modelId
        room1.setModelId(Tools.getModelId(user,project,room1));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.getModel(response,room1,user,project,room1ModelVersion);
    }

    @Test(description = "更新模型，上传相同的模型")
    public void testAddModel05() throws Exception {
        HttpClientResponse response = addModel.addModel(user,project,room1);
        System.out.println(response);
        //给模型设置modelId
        room1.setModelId(Tools.getModelId(user,project,room1));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.addModel(response,room1,user,project,++room1ModelVersion);
    }

    @Test(description = "得到项目的模型视图列表，1个")
    public void testAddModel06() throws Exception {
        HttpClientResponse response = getModels.getModels(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.getModels(response,user,project,modelNumber);
    }

    @Test(description = "新增模型，多模型")
    public void testAddModel07() throws Exception {
        HttpClientResponse response = addModel.addModel(user,project,room2);
        System.out.println(response);
        //给模型设置modelId
        room2.setModelId(Tools.getModelId(user,project,room2));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.addModel(response,room2,user,project,room2ModelVersion);
    }

    @Test(description = "得到项目的模型视图列表，2个")
    public void testAddModel08() throws Exception {
        HttpClientResponse response = getModels.getModels(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.getModels(response,user,project,++modelNumber);
    }

    @Test(description = "删除模型")
    public void testAddModel09() throws Exception {
        HttpClientResponse response = deleteModel.deleteModel(user,project,room1);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.deleteModel(response);
    }

    @Test(description = "得到项目的模型视图列表，1个")
    public void testAddModel10() throws Exception {
        HttpClientResponse response = getModels.getModels(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.getModels(response,user,project,--modelNumber);
    }

    @BeforeClass(description = "给模型赋值")
    public void beforeClass() throws Exception {
        String projectId = Tools.getProjectId(user,project);
        //给模型设置projectid
        room1 = Start.room1;
        room1.setProjectId(projectId);
        //给模型设置projectid
        room2 = Start.room2;
        room2.setProjectId(projectId);
    }

    @AfterMethod(description = "将modelId设置为null")
    public void tearDown() throws Exception {
        room1.setModelId(null);
        room2.setModelId(null);
    }
}
