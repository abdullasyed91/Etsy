package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;
import utilities.ReadConfigFiles;
import java.util.List;
import java.util.Map;

public class SignIn_steps {

    WebDriver driver = Hooks.driver;

    @Given("^user is on the etsy home page$")
    public void userIsOnHomePage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("EtsyUrl"));
    }

    @When("^user clicks on sign in button and upon entering valid credentials enters submit$")
    public void signInWithValidCredentials() {
        new HomePage(driver)
                .clickOnSignIn()
                .enterEmail(ReadConfigFiles.getPropertyValues("EtsyEmail"))
                .enterPassword(ReadConfigFiles.getPropertyValues("EtsyPassword"))
                .clickSubmit();
    }

    @When("^user click on sign in button and upon entering invalid credentials enters submit$")
    public void signInWithInvalidCredentials(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : data) {
            new HomePage(driver)
                    .clickOnSignIn()
                    .enterEmail(cells.get("email"))
                    .enterPassword(cells.get("password"))
                    .clickSubmit();
        }
    }
    @Then("user will be able to go the profile from home page$")
    public void validateSuccessfulSignIn() {
        new HomePage(driver)
                .verifySignInSuccessful();
    }

    @Then("^user is shown error \"(.+?)\"$")
    public void validateUnsuccessfulSignIn(String error) {
        new HomePage(driver)
                .signInUnsuccessful(error);
    }
}
