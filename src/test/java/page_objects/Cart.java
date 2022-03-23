package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Cart {
    public WebDriver driver;

    private final By SlipperInCart = By.xpath("//*[contains(text(),'Crochet Slipper')]");
    private final By VikingRingInCart = By.xpath("//*[contains(text(),'9th-10th')]");

    private static final Logger LOGGER = LogManager.getLogger(Cart.class);

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public Cart validateTheSlippersInCart() {
        LOGGER.debug("Validating the slipper is in cart");
        ActOn.validate(driver, SlipperInCart).elementIsDisplayed();
        return this;
    }

    public Cart validateVikingRingInCart() {
        LOGGER.debug("validating the viking ring is in cart");
        driver.navigate().refresh();
        ActOn.validate(driver, VikingRingInCart).elementIsDisplayed();
        return this;
    }
}
