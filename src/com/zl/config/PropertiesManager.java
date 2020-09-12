package com.zl.config;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private final Properties properties = new Properties();

    private static PropertiesManager propertiesManager;
    private PropertiesManager() {
        try {
            properties.load(PropertiesManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesManager getPropertiesManagerInstance() {
        if (propertiesManager == null)
            propertiesManager = new PropertiesManager();
        return propertiesManager;
    }

    public Object getConfig(String key){
        return properties.get(key);
    }

    public int getIntConfig(String key) {
        return Integer.parseInt((String) properties.get(key));
    }

    public String getStringConfig(String key) {
        return (String) properties.get(key);
    }


//    //测试配置文件读取
//    public static void main(String[] args) {
//        System.out.println(PropertiesManager.getConfig("initTankCount"));
//    }

}
