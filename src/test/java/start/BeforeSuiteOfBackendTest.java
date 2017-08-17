package start;

import com.decobim.database.Connection.ConnetionFactory;
import com.decobim.database.mysql.Dao;
import com.decobim.database.mysql.Table;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/8/17.
 */
public class BeforeSuiteOfBackendTest {

    @BeforeSuite(description = "清理decobim数据库")
    public void clearDecobim(){
        Connection conn = ConnetionFactory.getMysqlConnection();
        String sql;
        for(String tableName : Table.decbim){
            sql = String.format("delete from %s",tableName);
            Dao.doDelete(sql,conn);
        }
        //删除role表中数据
        sql = "delete from role where roleId > 180";
        Dao.doDelete(sql,conn);
        //关闭conn
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
