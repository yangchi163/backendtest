package testMember;

import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.project.CreateProject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/15.
 */
public class BeforeTestOfMember {
    private Registry registry = new Registry();
    private CreateProject createProject = new CreateProject();
    @BeforeTest
    public void beforeTest01() throws Exception {
        User user = User.user11();
        Project project = Project.jingjiLake();
        registry.registry(user);
        createProject.createProject(user,project);
    }
    @Test
    public void beforeTestOfMember(){
        System.out.println("beforeTestOfMember");
    }
}
