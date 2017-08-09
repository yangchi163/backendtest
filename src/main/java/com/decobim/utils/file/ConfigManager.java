package com.decobim.utils.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/8/8.
 */
public class ConfigManager {
    private Properties properties;

    public ConfigManager(String configFile) {
        properties = new Properties();
        InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getString(String key){
        return  properties.getProperty(key);
    }
}
