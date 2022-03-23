package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.NavigationBar;
import page_objects.PendantPage;
import utilities.ReadConfigFiles;

public class BuyingPendant_steps {
    WebDriver driver = Hooks.driver;
    private static final Logger LOGGER = LogManager.getLogger(BuyingPendant_steps.class);

    @When("^user navigates to the pendant section in the jewelry tab$")
    public void navigateToPendantInJewelry() {
        new NavigationBar(driver)
                .mouseHoverToJewelryTab()
                .mouseHoverToNecklace()
                .clickOnPendant();
        LOGGER.debug("Navigating to the jewelry tab and clicking on pendant");
    }

    @And("^the user adds the pendant to cart$")
    public void addPendantToCart() {
        new PendantPage(driver)
                .clickOnRainDropPendant()
                .selectNecklaceLength()
                .selectNecklaceStyle()
                .addToCart()
                .goToCart()
                .checkOut()
                .enterEmail(ReadConfigFiles.getPropertyValues("EtsyEmail"))
                .clickContinue()
                .enterPassword(ReadConfigFiles.getPropertyValues("EtsyPassword"))
                .clickOnSignIn();
        LOGGER.debug("Adding the pendant to cart");
    }

    @Then("^the user is able to purchase the pendant$")
    public void purchasePendant() {
        new PendantPage(driver)
                .validateUserOnShippingPage();
    }
}
