package testMember;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Member;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.Role;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.ResultCode;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertMember;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.member.*;
import com.decobim.utils.Tools;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */
public class TestAddMember {
    private Registry registry = new Registry();
    private GetMemberListOfProject getMemberListOfProject = new GetMemberListOfProject();
    private GetRoleListOfSbInProject getRoleListOfSbInProject = new GetRoleListOfSbInProject();
    private AddMember addMember = new AddMember();
    private CreateInvitation createInvitation = new CreateInvitation();
    private GetRoleListOfProject getRoleListOfProject = new GetRoleListOfProject();
    private DeleteMember deleteMember = new DeleteMember();
    private User user = User.user11();
    private User user12 = User.user12();
    private Role guanLiYuan = Role.guanLiYuan();
    private Role anQuanYuan = Role.anQuanYuan();
    private Role caiLiaoYuan = Role.caiLiaoYuan();
    private Member member = Member.memberA();            //需要设置projectId，roleId，userId/mobile
    private Project project = Project.jingjiLake();

    @Test(description = "查看项目成员：只有管理员")
    public void testAddMember01() throws Exception {
        System.out.println("testAddMember01");
        HttpClientResponse response = getMemberListOfProject.getMemberListOfProject(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertMember.getMemberListOfProject(response,"1");
    }

    @Test(description = "查看用户在项目中的角色列表,1个角色")
    public void testAddMember02() throws Exception {
        System.out.println("testAddMember02");
        List<Role> list = new ArrayList<>();
        list.add(guanLiYuan);
        HttpClientResponse response = getRoleListOfSbInProject.getRoleListOfSbInProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMember.getRoleListOfSbInProject(response,list);
    }

    @Test(description = "添加项目成员-已经存在的用户")
    public void testAddMember03() throws Exception {
        System.out.println("testAddMember03");
        member.setProjectId(Tools.getProjectId(user,project));
        member.setRoleId(anQuanYuan.getRoleId());
        member.setUserId(Tools.getUserId(user));
        member.setMobile(null);
        HttpClientResponse response = addMember.addMember(user,project,member);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMember.addMember(response,member);
    }

    @Test(description = "同一个人添加同一个角色")
    public void testAddMember04() throws Exception {
        System.out.println("testAddMember04");
        member.setProjectId(Tools.getProjectId(user,project));
        member.setRoleId(anQuanYuan.getRoleId());
        member.setUserId(Tools.getUserId(user));
        member.setMobile(null);
        HttpClientResponse response = addMember.addMember(user,project,member);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.PARAMETERERROR);
        AssertCommon.returnException(response,"该项目成员已存在不能重复添加", ResultCode.ERROR_DUPLICATED_INSTANCE);
    }

    @Test(description = "查看项目成员，一个人有2个角色")
    public void testAddMember05() throws Exception {
        System.out.println("testAddMember05");
        HttpClientResponse response = getMemberListOfProject.getMemberListOfProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertMember.getMemberListOfProject(response,"2");
    }

    @Test(description = "查看用户在项目中的角色列表,2个角色")
    public void testAddMember06() throws Exception {
        System.out.println("testAddMember06");
        List<Role> list = new ArrayList<>();
        list.add(guanLiYuan);
        list.add(anQuanYuan);
        HttpClientResponse response = getRoleListOfSbInProject.getRoleListOfSbInProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMember.getRoleListOfSbInProject(response,list);
    }

    @Test(description = "项目中的所有角色列表")
    public void testAddMember07() throws Exception {
        System.out.println("testAddMember07");
        List<Role> list = new ArrayList<>();
        list.add(guanLiYuan);
        list.add(anQuanYuan);
        HttpClientResponse response = getRoleListOfProject.getRoleListOfProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMember.getRoleListOfProject(response,list);
    }

    @Test(description = "创建邀请")
    public void testAddMember08() throws Exception {
        System.out.println("testAddMember08");
        member.setMobile(user12.getUserName());
        member.setRoleId(anQuanYuan.getRoleId());
        member.setProjectId(Tools.getProjectId(user,project));
        member.setUserId(null);
        HttpClientResponse response = createInvitation.createInvitation(user,project,member);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMember.createInvitation(response,member);
    }

    @Test(description = "重复邀请同一个人")
    public void testAddMember09() throws Exception {
        System.out.println("testAddMember09");
        member.setMobile(user12.getUserName());
        member.setRoleId(anQuanYuan.getRoleId());
        member.setProjectId(Tools.getProjectId(user,project));
        member.setUserId(null);
        HttpClientResponse response = createInvitation.createInvitation(user,project,member);
        //System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.CONFLICT);
        AssertCommon.returnException(response,"邀请已经存在在了",ResultCode.ERROR_DUPLICATED_INSTANCE);
    }

    @Test(description = "查看项目成员")
    public void testAddMember10() throws Exception {
        System.out.println("testAddMember10");
        HttpClientResponse response = getMemberListOfProject.getMemberListOfProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertMember.getMemberListOfProject(response,"2");
    }

    @Test(description = "被邀请的人注册后，自动成为项目成员")
    public void testAddMember11() throws Exception {
        System.out.println("testAddMember11");
        registry.registry(user12);

        HttpClientResponse response = getMemberListOfProject.getMemberListOfProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertMember.getMemberListOfProject(response,"3");
    }

    @Test(description = "删除项目成员，有2个角色")
    public void testAddMember12() throws Exception {
        System.out.println("testAddMember12");
        //给user12再加一个角色
        member.setProjectId(Tools.getProjectId(user,project));
        member.setRoleId(caiLiaoYuan.getRoleId());
        member.setUserId(Tools.getUserId(user12));
        member.setMobile(null);
        HttpClientResponse response = addMember.addMember(user,project,member);
        AssertCommon.statusCode(response,StatusCode.OK);
        response = deleteMember.deleteMember(user,project,user12);
        AssertCommon.statusCode(response,StatusCode.OK);
        //System.out.println(response);
    }

    @Test(description = "查看项目成员，验证删除成功")
    public void testAddMember13() throws Exception {
        System.out.println("testAddMember13");
        HttpClientResponse response = getMemberListOfProject.getMemberListOfProject(user,project);
        //System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertMember.getMemberListOfProject(response,"3");
    }
}
