package utils;
import factory.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

    private WebDriver _driver = DriverFactory.getDriver();

    public String takeScreenShot(Scenario scenario) {
        String sourcePath = null;
        if (scenario.isFailed()) {
            sourcePath = ((TakesScreenshot) _driver).getScreenshotAs(OutputType.BASE64);
        }
        return sourcePath;
    }
}
