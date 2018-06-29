package dataProvider;

import java.io.*;
import java.util.Properties;

public class Configurations {

    private static final Properties properties;
    private static File file = new File("C:/Users/Maksym_Rutskyi/Desktop/Learning Projects/RiaCucumberProject/configs/Configuration.properties");
    private static FileInputStream fileInputStream = null;

    static {
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        properties = new Properties();

        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath != null) {
            return driverPath;
        }
        else {
            throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
        }
    }

    public static long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) {
            return Long.parseLong(implicitlyWait);
        }
        else {
            throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
        }
    }

    public static String getUrl() {
        String url = properties.getProperty("URL");
        if(url != null) {
            return url;
        }
        else {
            throw new RuntimeException("url not specified in the Configuration.properties file.");
        }
    }
}
