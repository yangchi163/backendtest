package com.decobim.database.Connection;

import com.decobim.utils.file.ConfigManager;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/8/9.
 */
public class ConnetionFactory {
    private static String MYSQLDRIVER;
    private static String MYSQLURL;
    private static String MYSQLUSER;
    private static String MYSQLPASSWORD;
    private static String MONGOURI;

    static {
        String configFile = null;
        if ("TEST".equals(new ConfigManager("ENV.properties").getString("enviroment"))) {
            configFile = "testDatabase.properties";
        }
        ConfigManager configManager = new ConfigManager(configFile);
        MYSQLDRIVER = configManager.getString("mysql.driver");
        MYSQLURL = configManager.getString("mysql.url");
        MYSQLUSER = configManager.getString("mysql.user");
        MYSQLPASSWORD = configManager.getString("mysql.password");
        MONGOURI = configManager.getString("mongo.uri");
    }

    public static Connection getMysqlConnection() {
        Connection conn = null;
        try {
            Class.forName(MYSQLDRIVER);
            conn = DriverManager.getConnection(MYSQLURL, MYSQLUSER, MYSQLPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static MongoClient getMongoClient() {
        return new MongoClient(new MongoClientURI(MONGOURI));
    }

}
