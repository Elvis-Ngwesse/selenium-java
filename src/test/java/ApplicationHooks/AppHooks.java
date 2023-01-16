package ApplicationHooks;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import reports.ExtentReporting;
import utils.ConfigReader;

import java.io.IOException;

public class AppHooks {
    private DriverFactory _driverFactory;
    private WebDriver _webDriver;
    private ConfigReader _configReader;
    private ExtentReporting _extentReporting = new ExtentReporting();

    @Before
    public void getProperty(){
        _configReader = new ConfigReader();
        String _browserName = _configReader.getValueFromConfig("browser");
        _driverFactory = new DriverFactory();
        _webDriver = _driverFactory.initialize_driver(_browserName);
    }


    @After
    public void tearDown(Scenario _scenario) throws IOException {
        _extentReporting.generateExtentReport(_scenario);
        _webDriver.quit();
    }

    @AfterAll
    public static void afterAll() {
        ExtentReporting.flushReport();
    }
}
