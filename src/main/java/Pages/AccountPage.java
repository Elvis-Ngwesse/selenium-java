package Pages;
import org.openqa.selenium.By;
import utils.BaseClass;

public class AccountPage extends BaseClass {
    private By welcomeText = By.cssSelector("[id='flash-messages']>div");
    private By logoutButton = By.cssSelector("i[class*='signout']");

    public AccountPage() {
    }

    public String getWelcomeText() {
        String text = getElementText(welcomeText);
        return text;
    }

    public void clickOnLogoutButton() {
        click(logoutButton);
    }
}

