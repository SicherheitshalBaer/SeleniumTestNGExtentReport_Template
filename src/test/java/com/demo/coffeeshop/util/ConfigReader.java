package com.demo.coffeeshop.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getPropertyObject() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/java/com/demo/coffeeshop/config/config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties;
    }

    public static String getValue(String value) throws IOException {

        return(getPropertyObject().getProperty(value));
    }

    public static String getUsername() throws IOException {

        return(getPropertyObject().getProperty("username"));
    }

    public static String getPassword() throws IOException {

        return(getPropertyObject().getProperty("password"));
    }

    public static String getChromePath() throws IOException {

        return(getPropertyObject().getProperty("CHROMEDRIVER_PATH"));
    }

    public static String getFirefoxPath() throws IOException {

        return(getPropertyObject().getProperty("GECKODRIVER_PATH"));
    }

    public static String getEdgePath() throws IOException {

        return(getPropertyObject().getProperty("EDGEDRIVER_PATH"));
    }

    public static String getScreenshotDirCreate() throws IOException {

        return(getPropertyObject().getProperty("screenshot_dir_create"));
    }

    public static String getScreenshotDirGet() throws IOException {

        return(getPropertyObject().getProperty("screenshot_dir_get"));
    }




}
