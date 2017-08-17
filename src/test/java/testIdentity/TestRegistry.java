package testIdentity;

import com.decobim.model.prrepareForAssert.ResultCode;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertIdentity;
import com.decobim.services.main.identity.Registry;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/8.
 */
public class TestRegistry {
    private Registry registry = new Registry();
    @Test(description = "手机号已注册")
    public void testRegistry01() throws Exception {
        System.out.println("testRegistry01");
        User user = User.user1();
        HttpClientResponse response = registry.registry(user);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.PARAMETERERROR);
        AssertCommon.returnException(response,"手机已经注册啦", ResultCode.ERROR_CONFLICT_MOBILE);
    }
    @Test(description = "手机号未注册")
    public void testRegistry02() throws Exception {
        System.out.println("testRegistry02");
        User user = User.user2();
        HttpClientResponse response = registry.registry(user);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertIdentity.registry(response,user);
    }

}
