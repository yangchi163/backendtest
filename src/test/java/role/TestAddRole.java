package role;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Role;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertRole;
import com.decobim.services.main.role.*;
import com.decobim.utils.Tools;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/16.
 */
public class TestAddRole {
    private AddRole addRole = new AddRole();
    private GetRoleList getRoleList = new GetRoleList();
    private GetRole getRole = new GetRole();
    private ModifyRole modifyRole = new ModifyRole();
    private DeleteRole deleteRole = new DeleteRole();
    private Role guanliyuan = Role.guanLiYuan();
    private Role chengXuYuan = Role.chengxuyuan();
    private Role forModify = Role.forModify();
    private Role ceshiyuan1 = Role.ceshiyuan1();
    private Role ceshiyuan2 = Role.ceshiyuan2();
    private User user = User.user10();

    @Test(description = "获取角色列表")
    public void testAddRole01() throws Exception {
        HttpClientResponse response = getRoleList.getRoleList(user);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertCommon.assertPaging(response,"1","10","9");
        AssertRole.getRoleList(response,"9");
    }

    @Test(description = "添加角色")
    public void testAddRole02() throws Exception {
        HttpClientResponse response = addRole.addRole(user,chengXuYuan);
        System.out.println(response);
        chengXuYuan.setRoleId(Tools.getRoleId(user,chengXuYuan));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertRole.addRole(response,chengXuYuan);
    }

    @Test(description = "验证角色列表多一个")
    public void testAddRole03() throws Exception {
        HttpClientResponse response = getRoleList.getRoleList(user);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertRole.getRoleList(response,"10");
    }

    @Test(description = "查看角色,存在")
    public void testAddRole04() throws Exception {
        HttpClientResponse response = getRole.getRole(user,guanliyuan.getRoleId());
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertRole.getRole(response,guanliyuan);
    }

    @Test(description = "查看角色，不存在")
    public void testAddRole05() throws Exception {
        HttpClientResponse response = getRole.getRole(user,"99");
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.SERVERERROR);
        AssertCommon.returnException(response);
    }

    @Test(description = "修改角色,roleId与role中roleId不同")
    public void testAddRole06() throws Exception {
        addRole.addRole(user,ceshiyuan1);
        ceshiyuan2.setRoleId(Tools.getRoleId(user,guanliyuan));
        HttpClientResponse response = modifyRole.modifyRole(Tools.getAuth(user),Tools.getRoleId(user,ceshiyuan1),ceshiyuan2);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.PARAMETERERROR);
    }

    @Test(description = "修改角色，修改角色,roleId与role中roleId相同")
    public void testAddRole07() throws Exception {
        forModify.setRoleId(Tools.getRoleId(user,chengXuYuan));
        HttpClientResponse response = modifyRole.modifyRole(user,forModify);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertRole.modifyRole(response,forModify);
    }

    @Test(description = "删除角色，角色不存在")
    public void testAddRole08() throws Exception {
        HttpClientResponse response = deleteRole.deleteRole(user,"99");
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.SERVERERROR);
        AssertCommon.returnException(response);
    }

    @Test(description = "删除角色，角色存在")
    public void testAddRole09() throws Exception {
        HttpClientResponse response = deleteRole.deleteRole(user,Tools.getRoleId(user,forModify));
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
    }

    @Test(description = "验证角色列表少一个")
    public void testAddRole10() throws Exception {
        HttpClientResponse response = getRoleList.getRoleList(user);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertRole.getRoleList(response,"10");
    }
}
