package testMeasurement;

import com.decobim.model.http.HttpClientResponse;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.ModelElement;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.model.prrepareForAssert.StatusCode;
import com.decobim.services.assertResult.AssertCommon;
import com.decobim.services.main.measurement.BindBidSheetBill;
import com.decobim.services.main.measurement.UnbindBidSheetBillInfo;
import com.decobim.utils.Tools;
import org.testng.TestNGAntTask;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import start.Start;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
public class TestBindBidSheetBill {
    private BindBidSheetBill bindBidSheetBill = new BindBidSheetBill();
    private UnbindBidSheetBillInfo unbindBidSheetBillInfo = new UnbindBidSheetBillInfo();
    private User user = User.user33();
    private Project project = Project.jingjiLake();
    private Model model;
    private List<String> bidSheetBillInfoIds;

    @Test(description = "绑定投标清单到构件,不存在的构建")
    public void testBindBidSheetBill01() throws Exception {
        String bidSheetBillInfoId = bidSheetBillInfoIds.get(0);
        List<String> elements = new ArrayList<>();
        elements.add(ModelElement.FalseElement.getId());
        HttpClientResponse response = bindBidSheetBill.bindBidSheetBill(user,project,model,elements,bidSheetBillInfoId);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
    }

    @Test(description = "绑定投标清单到构件,存在的构建")
    public void testBindBidSheetBill02() throws Exception {
        String bidSheetBillInfoId = bidSheetBillInfoIds.get(0);
        List<String> elements = new ArrayList<>();
        elements.add(ModelElement.TrueElement.getId());
        HttpClientResponse response = bindBidSheetBill.bindBidSheetBill(user,project,model,elements,bidSheetBillInfoId);
        System.out.println(response);
        AssertCommon.statusCode(response, StatusCode.OK);
    }

    @BeforeClass(description = "准备模型")
    public void beforeClass() throws Exception {
        model = Start.room1;
        bidSheetBillInfoIds = Tools.getBidSheetBillInfoIds(user,project);
    }

}
