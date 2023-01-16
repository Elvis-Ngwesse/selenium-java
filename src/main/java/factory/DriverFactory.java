package factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;
    public  static ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    public  WebDriver initialize_driver(String browser_type){

        if(browser_type.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            _driver.set(new ChromeDriver());
        }else {
            WebDriverManager.firefoxdriver().setup();
            _driver.set(new FirefoxDriver());
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return  getDriver();
    };
    public static synchronized WebDriver getDriver(){
        return _driver.get();
    }
}
