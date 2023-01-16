package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public String getValueFromConfig(String stringName){
        Properties _properties = this.int_prop();
        return _properties.getProperty(stringName);
    }

    public String readFile(String filePath) {
       String jsonObject = null;
        try {
            jsonObject = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
