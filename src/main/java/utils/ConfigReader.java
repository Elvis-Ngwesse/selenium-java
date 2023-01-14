package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;
    public Properties int_prop(){
        prop = new Properties();
        try {
            FileInputStream stream = new FileInputStream("src/test/Config/config.properties");
            prop.load(stream);
        }catch (IOException e){
            e.getStackTrace();
        }
        return prop;
    }
}
