package ApplicationHooks;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class AppHooks {
    private DriverFactory _driverFactory;
    private WebDriver _webDriver;
    private ConfigReader _configReader;

    @Before
    public void getProperty(){
        _configReader = new ConfigReader();
        String _browserName = _configReader.getValueFromConfig("browser");
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
