package page_objects;

import command_providers.ActOn;
import io.cucumber.java.en_old.Ac;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class ValentineShop {
    public WebDriver driver;

    private final By LavenderCandle = By.xpath("//*[contains(text(),'Lavender Candle')]");
    private final By AddToCart = By.xpath("//*[@id='listing-page-cart']//*[@type='submit']");
    private final By CheckOutButton = By.xpath("//*[@id='multi-shop-cart-list']//*[contains(text(),'checkout')]");
    private final By SecureCheckout = By.xpath("//*[@id='gnav-header-inner']/div[1]/span");
    private final By EmailInput = By.id("join_neu_email_field");
    private final By ContinueButton = By.name("submit_attempt");
    private final By PasswordInput = By.id("join_neu_password_field");
    private final By SignInButton = By.name("submit_attempt");
    private final By StaySignInOption = By.id("persisent");
    private final By ShippingDetails = By.xpath("//*[@id='shipping-address-form']/div[1]/h1");

    private static final Logger LOGGER = LogManager.getLogger(ValentineShop.class);

    public ValentineShop(WebDriver driver) {
        this.driver = driver;
    }


    public ValentineShop clickOnCandle() {
        ActOn.element(driver, LavenderCandle).click();
        LOGGER.debug("Clicking on lavender candle and going to the candle page");
        return this;
    }

    public ValentineShop addCandleToCart() throws AWTException {
//        String newWindow = driver.getWindowHandle();
//        driver.findElement(AddToCart).sendKeys(Keys.CONTROL + "t");
//        driver.get("https://www.etsy.com/listing/766809902/lavender-candle-handmade-soy-candles?click_key=b8fe42d28c8127178b0bcf5d4e9d6d172a0fdc8c%3A766809902&click_sum=c61f1d7e&external=1&ref=finds_l-2&frs=1");
//        Robot r = new Robot();
//        r.keyPress(KeyEvent.VK_CONTROL);
//        r.keyPress(KeyEvent.VK_T);
//        r.keyRelease(KeyEvent.VK_CONTROL);
//        r.keyRelease(KeyEvent.VK_T);
//        Actions action= new Actions(driver);
//        action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
//        driver.switchTo().window(driver.getWindowHandle());
//        driver.switchTo().window(newWindow);
//        driver.get("https://www.etsy.com/listing/766809902/lavender-candle-handmade-soy-candles?click_key=b8fe42d28c8127178b0bcf5d4e9d6d172a0fdc8c%3A766809902&click_sum=c61f1d7e&external=1&ref=finds_l-2&frs=1");

        String originalWindow = driver.getWindowHandle();

        LOGGER.debug("Handling the new tab");
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.findElement(AddToCart).click();
        LOGGER.debug("Adding the candle to cart");
        return this;
    }
    public ValentineShop clickOnCheckOut() {
        LOGGER.debug("Clicking on checkout after adding the candle to cart");
        ActOn.element(driver, CheckOutButton).click();
        return this;
    }

    public ValentineShop enterEmail(String email) {
        ActOn.element(driver, EmailInput).setValue(email);
        return this;
    }

    public ValentineShop clickContinue() {
        LOGGER.debug("Signing in to continue to buy the candle");
        ActOn.element(driver, ContinueButton).click();
        return this;
    }

    public ValentineShop enterPassword(String password) {
        ActOn.element(driver, PasswordInput).setValue(password);
        return this;
    }

    public ValentineShop deselectStaySignedInOption() {
        ActOn.element(driver, StaySignInOption).click();
        return this;
    }

    public ValentineShop clickOnSignIn() {
        ActOn.element(driver, SignInButton).click();
        return this;
    }

    public ValentineShop validateUserIsOnShippingPage() {
        LOGGER.debug("Landing on the checkout page with the shipping details");
        ActOn.validate(driver, ShippingDetails).elementIsDisplayed();
        return this;
    }

}