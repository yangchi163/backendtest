package testUser;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertUser;
import com.decobim.services.main.user.GetUser;
import org.testng.annotations.Test;

/**
 * Created by jtl on 2017/8/10.
 */
public class TestGetUser {
    private GetUser getUser = new GetUser();
    private String roleId;

    //查看自己
    @Test
    public void testGetUser01()throws Exception{
        User user = User.user4();
        HttpClientResponse response = getUser.getUser(user,user);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertUser.getCurrentUser(response,user);
    }
    //查看别人
    @Test
    public void testGetUser02()throws Exception{
        User user = User.user4();
        User other = User.user5();
        HttpClientResponse response = getUser.getUser(user,other);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertUser.getCurrentUser(response,other);
    }
}
