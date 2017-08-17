package com.decobim.database.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/8/17.
 */
public class Dao {
    public static void doDelete(String sql, Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
