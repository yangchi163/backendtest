package testModel;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.ModelView;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertModel;
import com.decobim.services.main.model.AddModelView;
import com.decobim.services.main.model.GetModelView;
import com.decobim.services.main.model.GetModelViews;
import com.decobim.utils.Tools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import start.Start;

/**
 * Created by Administrator on 2017/8/22.
 */
public class TestAddModelView {
    private GetModelViews getModelViews = new GetModelViews();
    private GetModelView getModelView = new GetModelView();
    private AddModelView addModelView = new AddModelView();
    private User user = User.user21();
    private Project project = Project.jingjiLake();
    private Model room1;
    private ModelView modelView = ModelView.modelView1();
    private int modelViewNumber = 0;

    @Test(description = "得到项目的模型视图列表")
    public void testAddModelView01() throws Exception {
        HttpClientResponse response = getModelViews.getModelViews(user,project,room1);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertModel.getModelViews(response, room1,modelViewNumber);
    }

    @Test(description = "新增模型视图")
    public void testAddModelView02() throws Exception {
        HttpClientResponse response = addModelView.addModelView(user,project,room1,modelView);
        System.out.println(response);
        //给modelview设置modelviewId
        modelView.setModelViewId(Tools.getModelViewId(user,project,room1,modelView));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.addModelView(response,modelView);
    }

    @Test(description = "得到项目的模型视图列表")
    public void testAddModelView03() throws Exception {
        HttpClientResponse response = getModelViews.getModelViews(user,project,room1);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.getModelViews(response, room1,++modelViewNumber);
    }

    @Test(description = "得到项目的模型视图")
    public void testAddModelView04() throws Exception {
        HttpClientResponse response = getModelView.getModelView(user,project,room1,modelView);
        System.out.println(response);
        //给modelview设置modelviewId
        modelView.setModelViewId(Tools.getModelViewId(user,project,room1,modelView));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertModel.getModelView(response,modelView);
    }

    @AfterMethod(description = "将modelviewId设置为null")
    public void tearDown() throws Exception {
        modelView.setModelViewId(null);
    }

    @BeforeClass(description = "准备model和modelview")
    public void beforeClass() throws Exception {
        room1 = Tools.getModel(Start.model_room1);
        String projectId = Tools.getProjectId(user,project);
        String modelId = Tools.getModelId(user,project,room1);
        room1.setProjectId(projectId);
        room1.setModelId(modelId);
        //给modelview设置
        modelView.setProjectId(projectId);
        modelView.setModelId(modelId);
    }
}
