package testBimModel;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.GlobalVariable;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertBimModel;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.main.bimModel.GetModelTree;
import com.decobim.utils.Tools;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import start.Start;

/**
 * Created by Administrator on 2017/8/23.
 */
public class TestGetModelTree {
    private GetModelTree getModelTree = new GetModelTree();
    private User user = User.user22();
    private Project project = Project.jingjiLake();
    private Model room1;

    @Test
    public void testGetModelTree01() throws Exception {
        HttpClientResponse response = getModelTree.getModelTree(user,project,room1);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertBimModel.getModelTree(response);
    }
    @BeforeClass(description = "准备模型")
    public void beforeClass() throws Exception {
        //导入模型后解析模型需要时间
        Thread.sleep(GlobalVariable.SleepTime);
        room1 = Start.room1;
    }
}
