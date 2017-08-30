package testMeasurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.*;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertMeasurement;
import com.decobim.services.main.measurement.*;
import com.decobim.utils.Tools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
public class TestImportBidSheetBillInfo {
    private GetDbVersionInfo getDbVersionInfo = new GetDbVersionInfo();
    private ImportBidSheetBillInfo importBidSheetBillInfo = new ImportBidSheetBillInfo();
    private GetBidBillVersionInfos getBidBillVersionInfos = new GetBidBillVersionInfos();
    private GetBidSheetBillGeoRegions getBidSheetBillGeoRegions = new GetBidSheetBillGeoRegions();
    private GetBidSheetBillSubParts getBidSheetBillSubParts = new GetBidSheetBillSubParts();
    private GetAllBidSheetBillInfo getAllBidSheetBillInfo = new GetAllBidSheetBillInfo();
    private GetBidSheetBillInfo getBidSheetBillInfo = new GetBidSheetBillInfo();
    private FuzzyBidSheetBillInfo fuzzyBidSheetBillInfo = new FuzzyBidSheetBillInfo();
    private GetStandardBillCodes getStandardBillCodes = new GetStandardBillCodes();
    private GetBidSheetBillInfosByIds getBidSheetBillInfosByIds = new GetBidSheetBillInfosByIds();
    private User user = User.user32();
    private Project project = Project.jingjiLake();
    private BidSheetBill zhonghang = BidSheetBill.zhongHang();
    private String userId;
    private String projectId;
    private int bidSheetBillNumber = 0;


    @Test(description = "算量数据库版本信息列表")
    public void testImportBidSheetBillInfo01() throws Exception {
        HttpClientResponse response = getDbVersionInfo.getDbVersionInfo(user);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
        AssertMeasurement.getDbVersionInfo(response);
    }

    @Test(description = "获取清单版本信息列表，没有")
    public void testImportBidSheetBillInfo02() throws Exception {
        HttpClientResponse response = getBidBillVersionInfos.getBidBillVersionInfos(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getBidBillVersionInfos(response,bidSheetBillNumber);
    }

    @Test(description = "导入清单")
    public void testImportBidSheetBillInfo03() throws Exception {
        HttpClientResponse response = importBidSheetBillInfo.importBidSheetBillInfo(user,project,zhonghang);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.importBidSheetBillInfo(response);
        //线程暂停5秒，服务器解析清单
        Thread.sleep(GlobalVariable.SleepTime);
    }

    @Test(description = "获取清单版本信息列表，一个")
    public void testImportBidSheetBillInfo04() throws Exception {
        HttpClientResponse response = getBidBillVersionInfos.getBidBillVersionInfos(user,project);
        System.out.println(response);
        //给清单设置userId
        zhonghang.setUserId(Tools.getUserId(user));
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getBidBillVersionInfos(response,zhonghang,++bidSheetBillNumber);
    }

    @Test(description = "再次导入清单")
    public void testImportBidSheetBillInfo05() throws Exception {
        HttpClientResponse response = importBidSheetBillInfo.importBidSheetBillInfo(user,project,zhonghang);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.importBidSheetBillInfo(response);
        //线程暂停5秒，服务器解析清单
        Thread.sleep(GlobalVariable.SleepTime);
    }

    @Test(description = "获取清单版本信息列表，2个")
    public void testImportBidSheetBillInfo06() throws Exception {
        HttpClientResponse response = getBidBillVersionInfos.getBidBillVersionInfos(user,project);
        //给清单设置userId
        zhonghang.setUserId(userId);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getBidBillVersionInfos(response,zhonghang,++bidSheetBillNumber);
    }

    @Test(description = "获取投标算量清单区域列表")
    public void testImportBidSheetBillInfo07() throws Exception {
       HttpClientResponse response = getBidSheetBillGeoRegions.getBidSheetBillGeoRegions(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getBidSheetBillGeoRegions(response,projectId,Tools.getBillVersionId(user,project));
    }

    @Test(description = "获取投标算量清单部位列表")
    public void testImportBidSheetBillInfo08() throws Exception {
        HttpClientResponse response = getBidSheetBillSubParts.getBidSheetBillSubParts(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getBidSheetBillSubParts(response,projectId,Tools.getBillVersionId(user,project));
    }

    @Test(description = "获取所有投标算量清单信息")
    public void testImportBidSheetBillInfo09() throws Exception {
        HttpClientResponse response = getAllBidSheetBillInfo.getAllBidSheetBillInfo(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getAllBidSheetBillInfo(response,Tools.getBillVersionId(user,project));
    }

    @Test(description = "获取投标算量清单信息")
    public void testImportBidSheetBillInfo10() throws Exception {
        HttpClientResponse response = getBidSheetBillInfo.getBidSheetBillInfo(user,project,"1","10");
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
    }

    @Test(enabled = false,description = "模糊查询投标算量清单信息")
    public void testImportBidSheetBillInfo11() throws Exception {
        HttpClientResponse response = fuzzyBidSheetBillInfo.fuzzyBidSheetBillInfo(user,project,"","1","10");
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
    }

    @Test(description = "查找某项目下的清单所对应的国标清单的清单编号和清单中的项目名称")
    public void testImportBidSheetBillInfo12() throws Exception {
        HttpClientResponse response = getStandardBillCodes.getStandardBillCodes(user,project);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getStandardBillCodes(response);
    }

    @Test(description = "根据投标清单id列表查询投标算量清单信息")
    public void testImportBidSheetBillInfo13() throws Exception {
        List<String> list = Tools.getBidSheetBillInfoIds(user,project);
        HttpClientResponse response = getBidSheetBillInfosByIds.getBidSheetBillInfosByIds(user,project,list);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertMeasurement.getBidSheetBillInfosByIds(response,list,Tools.getBillVersionId(user,project));
    }

    @BeforeClass(description = "给清单设置projectId")
    public void beforeClass() throws Exception {
        userId = Tools.getUserId(user);
        projectId = Tools.getProjectId(user,project);
        zhonghang.setProjectId(projectId);
    }

    @AfterMethod(description = "将清单的userId设置为null")
    public void afterMethod(){
        zhonghang.setUserId(null);
    }
}
