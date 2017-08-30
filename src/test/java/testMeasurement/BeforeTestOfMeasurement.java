package testMeasurement;

import com.decobim.model.prepareForTest.BidSheetBill;
import com.decobim.model.prepareForTest.Model;
import com.decobim.model.prepareForTest.Project;
import com.decobim.model.prepareForTest.User;
import com.decobim.services.main.identity.Registry;
import com.decobim.services.main.measurement.ImportBidSheetBillInfo;
import com.decobim.services.main.model.AddModel;
import com.decobim.services.main.project.AddMeasurementInfo;
import com.decobim.services.main.project.CreateProject;
import com.decobim.utils.Tools;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import start.Start;

/**
 * Created by Administrator on 2017/8/23.
 */
public class BeforeTestOfMeasurement {
    private Registry registry = new Registry();
    private CreateProject createProject = new CreateProject();
    private AddMeasurementInfo addMeasurementInfo = new AddMeasurementInfo();
    private AddModel addModel = new AddModel();
    private ImportBidSheetBillInfo importBidSheetBillInfo = new ImportBidSheetBillInfo();
    private User user = User.user32();
    private User user33 = User.user33();
    private Project project = Project.jingjiLake();
    private Model room1 = Start.room1;

    @BeforeTest
    public void beforeTest01() throws Exception {
        registry.registry(user);
        createProject.createProject(user,project);
        addMeasurementInfo.addMeasurementInfo(user,project);
        //为model设置projectId
        room1.setProjectId(Tools.getProjectId(user,project));
        addModel.addModel(user,project,room1);
    }

    @BeforeTest
    public void beforeTest02() throws Exception {
        registry.registry(user33);
        createProject.createProject(user33,project);
        //获取projectId
        String projectId = Tools.getProjectId(user33,project);
        //获得清单，并设置projectId
        BidSheetBill bidSheetBill = BidSheetBill.zhongHang();
        bidSheetBill.setProjectId(projectId);
        //获得模型并设置projectid
        Model model = Start.room1;
        model.setProjectId(projectId);

        addMeasurementInfo.addMeasurementInfo(user33,project);
        //导入清单
        importBidSheetBillInfo.importBidSheetBillInfo(user33,project,bidSheetBill);
        addModel.addModel(user33,project,model);
    }

    @Test
    public void beforeTestOfMeasurement() throws Exception {
        System.out.println("BeforeTestOfMeasurement");
    }
}
