package ApplicationHooks;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    public void getProperty(Scenario _scenario) {
        _configReader = new ConfigReader();
        String _browserName = _configReader.getValueFromConfig("browser");
        _driverFactory = new DriverFactory();
        _webDriver = _driverFactory.initialize_driver(_browserName);
        _extentReporting.generateExtentReport(_scenario);
    }

    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) _webDriver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        _extentReporting.logTestInReport(scenario);
    }


    @After(order = 0)
    public void tearDown(Scenario _scenario) {
        _extentReporting.flushTestReport();
        _webDriver.quit();
    }
}
