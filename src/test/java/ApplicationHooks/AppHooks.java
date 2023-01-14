package ApplicationHooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class AppHooks {
    private DriverFactory _driverFactory;
    private WebDriver _webDriver;
    private ConfigReader _configReader;
    Properties _properties;

    @Before
    public void getProperty(){
        _configReader = new ConfigReader();
        _properties = _configReader.int_prop();

        String _browserName = _properties.getProperty("browser");
        _driverFactory = new DriverFactory();
        _webDriver = _driverFactory.initialize_driver(_browserName);
    }


    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String _screenShotName = scenario.getName().replaceAll("","_");
            byte [] sourcePath = ((TakesScreenshot)_webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",_screenShotName);
        }

        _webDriver.quit();
    }
}
