package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LogoutPage extends BaseClass {
    private WebDriver _driver;
    private By logoutText = By.cssSelector("[id='flash-messages']>div");
    private By logoutButton = By.cssSelector("i[class*='signout']");

    public LogoutPage() {
    }

    public String getLogoutText() {
        String text = getElementText(logoutText);
        return text;
    }

    public String getLogoutPageUrl() {
        String url = getPageUrl();
        return url;
    }
}

