package testIdentity;

import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/9.
 */
public class BeforeTestOfIdentity {
    private Registry registry = new Registry();
    @BeforeTest
    public void beforeTest() throws Exception {
        User user = User.user1();
        registry.registry(user);
    }
    @Test
    public void beforeTestOfIdentity(){
        System.out.println("BeforeTestOfIdentity");
    }
}
