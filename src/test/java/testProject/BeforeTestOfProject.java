package testProject;

import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.project.CreateProject;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/10.
 */
public class BeforeTestOfProject {
    private Registry registry = new Registry();
    private CreateProject createProject = new CreateProject();
    @Test
    public void beforeTest01() throws Exception {
        User user = User.user6();
        registry.registry(user);
    }
    @Test
    public void beforeTestOfProject(){
        System.out.println("BeforeTestOfProject");
    }
}
