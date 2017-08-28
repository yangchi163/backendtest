package testBimModel;

import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.model.AddModel;
import com.decobim.services.main.project.CreateProject;
import com.decobim.utils.Tools;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import start.Start;

/**
 * Created by Administrator on 2017/8/23.
 */
public class BeforeTestOfBimModel {
    private Registry registry = new Registry();
    private CreateProject createProject = new CreateProject();
    private AddModel addModel = new AddModel();
    private User user = User.user22();
    private Project project = Project.jingjiLake();
    private Model room1;

    @BeforeTest
    public void beforeTest01() throws Exception {
        registry.registry(user);
        createProject.createProject(user,project);
        //准备模型，给模型设置projectId
        room1 = Start.room1;
        room1.setProjectId(Tools.getProjectId(user,project));
        addModel.addModel(user,project,room1);
    }

    @Test
    public void beforeTestOfBimModel() throws Exception {
        System.out.println("BeforeTestOfBimModel");
    }
}
