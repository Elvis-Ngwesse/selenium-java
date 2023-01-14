package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LogoutPage {
    private WebDriver _driver;
    private By logoutText = By.cssSelector("[id='flash-messages']>div");
    private By logoutButton = By.cssSelector("i[class*='signout']");
    private BaseClass baseClass = new BaseClass(_driver);

    public LogoutPage(WebDriver _driver) {
        this._driver = _driver;
    }

    public String getLogoutText() {
        String text = baseClass.getElementText(logoutText);
        return text;
    }
}

