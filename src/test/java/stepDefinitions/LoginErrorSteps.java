package stepDefinitions;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginErrorSteps {
    private LoginPage loginPage = new LoginPage();

    @Then("User should see error message {string}")
    public void userShouldSeeErrorMessage(String arg0) {
        String text = loginPage.getLoginErrorMessage();
        Assert.assertTrue(text.contains(arg0));
    }
}

