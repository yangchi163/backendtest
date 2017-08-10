package testUser;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.ResultCode;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertUser;
import com.decobim.services.main.user.GetCurrentUser;
import com.decobim.utils.Tools;
import org.testng.annotations.Test;

/**
 * Created by jtl on 2017/8/10.
 */
public class TestGetCurrentUser {
    private GetCurrentUser getCurrentUser = new GetCurrentUser();
    private String token;
    @Test(description = "未授权")
    public void testGetCurrentUser01()throws Exception{
        User user = User.user4();
        HttpClientResponse response =getCurrentUser.getCurrentUser(token);
        System.out.println(response);
//        AssertCommon.returnException(response,"UNAUTHORIZED", ResultCode.);
    }

    @Test
    public void testGetCurrentUser02()throws Exception{
        User user = User.user4();
        HttpClientResponse response =getCurrentUser.getCurrentUser(user);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertUser.getCurrentUser(response,user);
    }
}
