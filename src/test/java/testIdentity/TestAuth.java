package testIdentity;

import com.decobim.model.prepareForTest.User;
import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prrepareForAssert.ResultCode;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertIdentity;
import com.decobim.services.main.identity.Auth;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/9.
 */
public class TestAuth {
    private Auth auth = new Auth();

    @Test(description = "账号密码匹配")
    public void testAuth01() throws Exception {
        User user = User.user1();
        HttpClientResponse response = auth.auth(user);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertIdentity.auth(response);
    }

    @Test(description = "账号密码不匹配")
    public void testAuth02() throws Exception {
        User user = User.user1();
        HttpClientResponse response = auth.auth(user.getUserName(),user.getErrorPwd());
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.PARAMETERERROR);
        AssertCommon.returnException(response,"账号密码不匹配", ResultCode.ERROR_INVALID);
    }

    @Test(description = "账号未注册")
    public void testAuth03() throws Exception {
        User user = User.user3();
        HttpClientResponse response = auth.auth(user);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.PARAMETERERROR);
        AssertCommon.returnException(response,"账号密码不匹配", ResultCode.ERROR_INVALID);
    }
}
