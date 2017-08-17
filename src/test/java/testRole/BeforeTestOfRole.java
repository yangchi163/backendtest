package testRole;

import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/16.
 */
public class BeforeTestOfRole {
    private Registry registry = new Registry();
    @BeforeTest
    public void beforeTest() throws Exception {
        User user = User.user10();
        registry.registry(user);
    }
    @Test
    public void beforeTestOfRole(){
        System.out.println("BeforeTestOfRole");
    }
}
