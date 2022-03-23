package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.security.PublicKey;

public class ClothingAndShoesPage {
    public WebDriver driver;


    private final By CrochetSlipper = By.xpath("//*[contains(text(),'Crochet Slipper')]");
    private final By SelectSize = By.id("inventory-variation-select-0");
    private final By DesiredSize = By.xpath("//*[@id='inventory-variation-select-0']/option[8]");
    private final By AddToCartButton = By.xpath("//*[@id='listing-page-cart']//*[@type='submit']");
    private final By Cart = By.linkText("https://www.etsy.com/cart?ref=hdr-cart");
    private final By SlipperInCart = By.xpath("//*[contains(text(),'Crochet Slipper')]");

    private static final Logger LOGGER = LogManager.getLogger(ClothingAndShoesPage.class);

    public ClothingAndShoesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ClothingAndShoesPage clickOnCrochetSlipper() {
        LOGGER.debug("Going to the crochet slipper page");
        ActOn.element(driver, CrochetSlipper).click();
        return this;
    }

    public ClothingAndShoesPage selectShoeSize() {
        String originalWindow = driver.getWindowHandle();

        LOGGER.debug("Handling the new tab");
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        LOGGER.debug("Selecting 7 for the shoe size");
        ActOn.element(driver, SelectSize).click();
        ActOn.element(driver, DesiredSize).click();
        return this;
    }

    public ClothingAndShoesPage addToCart() {
        LOGGER.debug("Adding the slipper to cart");
        ActOn.element(driver, AddToCartButton).click();
        return this;
    }

}
