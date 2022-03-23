package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Cart;
import page_objects.NavigationBar;

public class BuyingRing_steps {
    WebDriver driver = Hooks.driver;
    private static final Logger LOGGER = LogManager.getLogger(BuyingRing_steps.class);

    @When("^user searches for men rings$")
    public void navigateToMenRingsInVintageRings() {
        new NavigationBar(driver)
                .searchForRings("rings for men");
    }

    @And("^the user adds the viking ring to cart after clicking on it$")
    public void addVikingRingToCart() {
        new NavigationBar(driver)
                .clickOnCarbonFiberRing()
                .addRingToCart();
    }

    @Then("^the use validates the ring is in the cart$")
    public void validateTheRingIsInCart() {
        new NavigationBar(driver)
                .navigateToCart();
        new Cart(driver)
                .validateVikingRingInCart();
    }
}
