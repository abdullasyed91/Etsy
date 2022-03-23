package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.NavigationBar;
import page_objects.ValentineShop;
import utilities.ReadConfigFiles;

import java.awt.*;


public class ValentinePage_steps {
    WebDriver driver = Hooks.driver;
    private static final Logger LOGGER = LogManager.getLogger(ValentinePage_steps.class);

    @When("^user adds lavender candle to cart after navigating to the valentine page$")
    public void addCandleToCart() throws AWTException {
        new NavigationBar(driver)
                .navigateToValentinePage();
        LOGGER.debug("Navigating to the valentine page");
        new ValentineShop(driver)
                .clickOnCandle()
                .addCandleToCart()
                .clickOnCheckOut()
                .enterEmail(ReadConfigFiles.getPropertyValues("EtsyEmail"))
                .clickContinue();
        LOGGER.debug("Adding the candle to the cart and going to the checkout page");
//                .enterPassword(ReadConfigFiles.getPropertyValues("EtsyPassword"))
//                .deselectStaySignedInOption()
//                .clickOnSignIn();
    }

    @Then("^user is able to successfully purchases the candles$")
    public void purchaseCandle() {
        new ValentineShop(driver)
                .validateUserIsOnShippingPage();
        LOGGER.debug("On the checkout page");
    }
}
