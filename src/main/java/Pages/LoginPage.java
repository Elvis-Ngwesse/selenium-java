package Pages;
import org.openqa.selenium.By;
import utils.BaseClass;

public class LoginPage extends BaseClass {
    private By username = By.id("username");
    private By errorMessage = By.cssSelector("[id='flash-messages']>div");
    private By pageTitle = By.cssSelector("div>div>h2");
    private By password = By.id("password");
    private By submit = By.cssSelector("button[type='submit']>i");

    public LoginPage(){
    }

    public void enterUserName(String text){
        enterTEXT(username,text);
    }

    public void enterUserPassword(String text){
        enterTEXT(password,text);
    }

    public void clickSubmitButton(){
        click(submit);
    }

    public String getPageTitle() {
        String text = getElementText(pageTitle);
        return text;
    }

    public String getLoginErrorMessage() {
        String text = getElementText(errorMessage);
        return text;
    }
}
