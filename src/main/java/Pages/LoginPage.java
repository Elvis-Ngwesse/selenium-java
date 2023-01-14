package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage {
    private WebDriver _driver;
    private By username = By.id("username");
    private By pageTitle = By.cssSelector("div>div>h2");
    private By password = By.id("password");
    private By submit = By.cssSelector("button[type='submit']>i");
    private BaseClass baseClass = new BaseClass(_driver);

    public LoginPage(WebDriver _driver){
        this._driver = _driver;
    }

    public void enterUserName(String text){
        baseClass.enterTEXT(username,text);
    }

    public void enterUserPassword(String text){
        baseClass.enterTEXT(password,text);
    }

    public void clickSubmitButton(){
        baseClass.click(submit);
    }

    public String getPageTitle() {
        String text = baseClass.getElementText(pageTitle);
        return text;
    }
}
