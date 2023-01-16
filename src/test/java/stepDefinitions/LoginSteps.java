package stepDefinitions;
import Pages.AccountPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class LoginSteps {
    private WebDriver _driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage();
    private AccountPage accountPage = new AccountPage();
    ConfigReader _configReader = new ConfigReader();
    LogoutPage logoutPage = new LogoutPage();

    @Given("User navigates to herokuapp homepage")
    public void userNavigatesToHerokuappHomepage() {
        String configString = _configReader.getValueFromConfig("herokuappUrl");
        _driver.get(configString);
        String loginPageTitle = "Login Page";
        String pageTitle = loginPage.getPageTitle();
        Assert.assertEquals(loginPageTitle,pageTitle);
    }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) {
        loginPage.enterUserName(arg0);
        loginPage.enterUserPassword(arg1);
    }
    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickSubmitButton();
    }

    @Then("User should see message {string}")
    public void userShouldSeeMessage(String arg0) {
        String welcomeText = accountPage.getWelcomeText();
        Assert.assertTrue(welcomeText.contains(arg0));
    }

    @And("User clicks on logout button")
    public void userClicksOnLogoutButton() {
        accountPage.clickOnLogoutButton();
    }

    @Then("User verifies page url {string}")
    public void userVerifiesPageUrl(String arg0) {
        String pageUrl = logoutPage.getLogoutPageUrl();
        Assert.assertTrue(pageUrl.contains(arg0));
    }
}

