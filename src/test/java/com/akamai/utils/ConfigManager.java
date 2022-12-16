package com.akamai.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    public static String getConfig(String property) {
        String element = null;
        Properties prop = new Properties();
        try(InputStream inputStream = ConfigManager.class.getResourceAsStream("/config.properties")) {
            prop.load(inputStream);
            element = prop.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return element;
    }

}
