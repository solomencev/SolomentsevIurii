package com.epam.pages.hw4.fragments.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static Properties getPropertyObject()  {
        try {
            String path = new File("src/test/resources/user.properties").getAbsolutePath();
            FileInputStream fp = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fp);
            return prop;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static String getUserNameFromProperties() {
        return getPropertyObject().getProperty("userName");
    }

    public static String getUserPasswordFromProperties()  {
        return getPropertyObject().getProperty("password");
    }

    public static String getUserFullNameFromProperties() {
        return getPropertyObject().getProperty("fullName");
    }
}
