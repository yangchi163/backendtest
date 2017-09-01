package testProcess;

import com.decobim.model.prepareForTest.BidSheetBill;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.measurement.ImportBidSheetBillInfo;
import com.decobim.services.main.project.AddMeasurementInfo;
import com.decobim.services.main.project.CreateProject;
import com.decobim.utils.Tools;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/8/31.
 */
public class BeforeTestOfProcess {
    private Registry registry = new Registry();
    private CreateProject createProject = new CreateProject();
    private AddMeasurementInfo addMeasurementInfo = new AddMeasurementInfo();
    private ImportBidSheetBillInfo importBidSheetBillInfo = new ImportBidSheetBillInfo();

    @Test
    public void beforeTest01() throws Exception {
        User user = User.user34();
        Project project = Project.jingjiLake();
        BidSheetBill bidSheetBill = BidSheetBill.zhongHang();
        registry.registry(user);
        createProject.createProject(user,project);
        addMeasurementInfo.addMeasurementInfo(user,project);
        bidSheetBill.setProjectId(Tools.getProjectId(user,project));
        importBidSheetBillInfo.importBidSheetBillInfo(user,project,bidSheetBill);
    }

    @Test
    public void beforeTestOfProcess() throws Exception {
        System.out.println("beforeTestOfProcess");
    }
}
