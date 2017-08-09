package testIdentity;

import com.decobim.model.User;
import com.decobim.model.http.HttpClientResponse;
import com.decobim.services.main.identity.Registry;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/8.
 */
public class TestRegistry {
    @Test
    public void testRegistry() throws Exception {
        Registry registry = new Registry();
        HttpClientResponse response = registry.registry(User.user37());
        System.out.println(response);
    }
}
