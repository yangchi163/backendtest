package start;

import com.decobim.database.Connection.ConnetionFactory;
import com.decobim.database.mysql.Dao;
import com.decobim.database.mysql.Table;
import com.decobim.utils.file.ConfigManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/8/17.
 */
public class Start {
    public static String model_room1;
    public static String model_room2;

    //读取属性文件
    static {
        ConfigManager manager = new ConfigManager("file.properties");
        model_room1 = manager.getString("room1");
        model_room2 = manager.getString("room2");
    }

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

    @Test
    public void start(){
        System.out.println("test is running......");
    }
}
