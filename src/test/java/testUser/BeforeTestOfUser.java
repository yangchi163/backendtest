package testUser;

import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/9.
 */
public class BeforeTestOfUser {
    private Registry registry = new Registry();
    @BeforeTest
    public void beforeTest() throws Exception {
        User user = User.user4();
        registry.registry(user);
        user = User.user5();
        registry.registry(user);
    }
    @Test
    public void beforeTestOfUser(){
        System.out.println("BeforeTestOfUser");
    }
}
