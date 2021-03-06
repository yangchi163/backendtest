package testProject;

import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.project.CreateProject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/10.
 */
public class BeforeTestOfProject {
    private Registry registry = new Registry();
    private CreateProject createProject = new CreateProject();
    private Project project = Project.jingjiLake();

    @BeforeTest
    public void beforeTest01() throws Exception {
        User user = User.user6();
        registry.registry(user);
    }

    @BeforeTest
    public void beforeTest02() throws Exception {
        User user = User.user7();
        registry.registry(user);
        createProject.createProject(user,project);
    }

    @Test
    public void beforeTestOfProject(){
        System.out.println("BeforeTestOfProject");
    }
}
