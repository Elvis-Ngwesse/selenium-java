package stepDefinitions;
import Pages.StatusCodePage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class StatusCodeSteps {
    private WebDriver _driver = DriverFactory.getDriver();
    ConfigReader _configReader = new ConfigReader();
    StatusCodePage statusCodePage = new StatusCodePage();

    @Given("User navigates to herokuappstatuscode homepage")
    public void userNavigatesToHerokuappStatuscodeHomepage() {
        String configString = _configReader.getValueFromConfig("herokuappStatuscodeUrl");
        _driver.get(configString);
    }

    @When("User clicks on status code (.*)$")
    public void userClicksOnStatusCodeStatus_codes(String status_codes) {
        statusCodePage.clickStatusCodeLink(status_codes);
    }

    @Then("User should see status_codes\\/{int} in page url")
    public void user_should_see_status_codes_in_page_url(Integer url) {
        String text = statusCodePage.getStatusCodePageUrl();
        Assert.assertTrue(text.contains(url.toString()));
    }
}

