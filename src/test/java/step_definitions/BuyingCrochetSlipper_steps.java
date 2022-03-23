package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Cart;
import page_objects.ClothingAndShoesPage;
import page_objects.HomePage;
import page_objects.NavigationBar;
import utilities.ReadConfigFiles;

public class BuyingCrochetSlipper_steps {
    WebDriver driver = Hooks.driver;
    private static final Logger LOGGER = LogManager.getLogger(BuyingCrochetSlipper_steps.class);

    @When("^user navigates to the women's boots in the clothing and shoes tab after signing in$")
    public void navigatingToBootsAfterSigningIn() {
        new HomePage(driver)
                .clickOnSignIn()
                .enterEmail(ReadConfigFiles.getPropertyValues("EtsyEmail"))
                .enterPassword(ReadConfigFiles.getPropertyValues("EtsyPassword"))
                .clickSubmit();
        new NavigationBar(driver)
                .mouseHoverToClothingAndShoesTab()
                .mouseHoverToWomenSection()
                .clickOnWomenBoots();
    }

    @And("^the user adds crochet boots to cart$")
    public void addBootsToCart() {
        new ClothingAndShoesPage(driver)
                .clickOnCrochetSlipper()
                .selectShoeSize()
                .addToCart();
    }

    @Then("^the user validates the boots are in the cart$")
    public void bootsAreInCart() {
        new NavigationBar(driver)
                .navigateToCart();
        new Cart(driver)
                .validateTheSlippersInCart();
    }
}
