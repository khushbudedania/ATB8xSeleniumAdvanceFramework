package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readkey(String key)
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data.properties");
            Properties p = new Properties();
            p.load(fileInputStream);
            return p.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
