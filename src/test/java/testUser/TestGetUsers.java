package testUser;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertUser;
import com.decobim.services.main.user.GetUsers;
import org.testng.annotations.Test;

/**
 * Created by jtl on 2017/8/10.
 */
public class TestGetUsers {
    private GetUsers getUsers = new GetUsers();

    //pageNum和pageSize默认
    @Test
    public void testGetUsers01()throws Exception{
        User user = User.user4();
        HttpClientResponse response =getUsers.getUsers(user);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertUser.getUsers(response);
    }

}
