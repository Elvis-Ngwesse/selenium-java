package stepDefinitions;
import ApplicationHooks.AppHooks;
import Pages.AccountPage;
import Pages.LoginPage;
import factory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private AppHooks appHooks = new AppHooks();
    private WebDriver _driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage(_driver);
    private AccountPage accountPage = new AccountPage(_driver);
    @io.cucumber.java.en.Given("User navigates to homepage")
    public void userNavigatesToHomepage() {
        _driver.get("http://the-internet.herokuapp.com/login");
        String loginPageTitle = "Login Page";
        String pageTitle = loginPage.getPageTitle();
        //Assert.assertEquals(loginPageTitle,pageTitle);
    }

    @io.cucumber.java.en.When("User enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) {
        loginPage.enterUserName(arg0);
        loginPage.enterUserPassword(arg1);
    }
    @io.cucumber.java.en.And("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickSubmitButton();
    }

    @io.cucumber.java.en.Then("User should see message {string}")
    public void userShouldSeeMessage(String arg0) {
        String welcomeText = accountPage.getWelcomeText();
        Assert.assertEquals(welcomeText, arg0);
    }
}

