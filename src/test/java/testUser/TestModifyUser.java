package testUser;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertUser;
import com.decobim.services.main.user.ModifyUser;
import com.sun.org.apache.regexp.internal.RE;
import org.testng.annotations.Test;

/**
 * Created by jtl on 2017/8/10.
 */
public class TestModifyUser {
    private ModifyUser modifyUser = new ModifyUser();

    @Test(description = "帮自己更改")
    public void testModifyUser01()throws Exception{
        User user = User.user5();
        HttpClientResponse response = modifyUser.modifyUser(user,user,user.getUserName());
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertUser.getCurrentUser(response,user);
    }

    @Test(description = "帮别人更改")
    public  void testModifyUser02()throws Exception{
        User user = User.user4();
        User other = User.user5();
        HttpClientResponse response = modifyUser.modifyUser(user,other,other.getUserName());
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertUser.getCurrentUser(response,other);
    }
}
