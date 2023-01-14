package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class AccountPage {
    private WebDriver _driver;
    private By welcomeText = By.cssSelector("[id='flash-messages']>div");
    private By logoutButton = By.cssSelector("i[class*='signout']");
    private BaseClass baseClass = new BaseClass(_driver);

    public AccountPage(WebDriver _driver) {
        this._driver = _driver;
    }

    public String getWelcomeText() {
        String text = baseClass.getElementText(welcomeText);
        return text;
    }

    public void clickOnLogoutButton() {
        baseClass.click(logoutButton);
    }
}

