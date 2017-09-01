package testProcess;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Process;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.assertResult.AssertProcess;
import com.decobim.services.main.process.AddProcess;
import com.decobim.services.main.process.GetProcess;
import com.decobim.utils.Tools;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */
public class TestAddProcess {
    private GetProcess getProcess = new GetProcess();
    private AddProcess addProcess = new AddProcess();
    private Process processA = Process.processA();
    private Process processB = Process.processB();
    private String bidSheetBillInfoIds;
    private User user = User.user34();
    private Project project = Project.jingjiLake();
    private static int processNumber = 0;

    @Test(description = "按清单查看工序")
    public void testAddProcess01() throws Exception {
        HttpClientResponse response = getProcess.getProcess(user,project,bidSheetBillInfoIds);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        processNumber = AssertProcess.getProcess(response,processNumber);
    }

    @Test(description = "新增工序")
    public void testAddProcess02() throws Exception {
        HttpClientResponse response = addProcess.addProcess(user,project,processA);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertProcess.addProcess(response,processA);
    }

    @Test(description = "按清单查看工序,数量+1")
    public void testAddProcess03() throws Exception {
        HttpClientResponse response = getProcess.getProcess(user,project,bidSheetBillInfoIds);
        System.out.println(response);
        AssertCommon.statusCode(response,StatusCode.OK);
        AssertProcess.getProcess(response,++processNumber);
    }

    @BeforeClass(description = "选择用哪一条清单，并为工序设置billId")
    public void beforeClass() throws Exception{
        List<String> list = Tools.getBidSheetBillInfoIds(user,project);
        bidSheetBillInfoIds = list.get(0);
        processA.setBillId(bidSheetBillInfoIds);
        processB.setBillId(bidSheetBillInfoIds);
    }
}
