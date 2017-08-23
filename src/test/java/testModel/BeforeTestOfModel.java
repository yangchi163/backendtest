package testModel;

import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.model.AddModel;
import com.decobim.services.main.project.CreateProject;
import com.decobim.utils.Tools;
import org.testng.annotations.Test;
import start.Start;

/**
 * Created by Administrator on 2017/8/21.
 */
public class BeforeTestOfModel {
    private Registry registry = new Registry();
    private CreateProject createProject = new CreateProject();
    private AddModel addModel = new AddModel();
    private Project project = Project.jingjiLake();

    @Test
    public void beforeTest01() throws Exception {
        User user = User.user20();
        registry.registry(user);
        createProject.createProject(user,project);
    }

    @Test
    public void beforeTest02() throws Exception {
        User user = User.user21();
        registry.registry(user);
        createProject.createProject(user,project);
        //准备model
        Model room1 = Tools.getModel(Start.model_room1);
        //设置modelId
        room1.setProjectId(Tools.getProjectId(user,project));
        //导入模型
        addModel.addModel(user,project, room1);
    }

    @Test
    public void beforeTestOfMember(){
        System.out.println("BeforeTestOfModel");
    }
}
