package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PendantPage {
    public WebDriver driver;

    private final By RainDropNecklace = By.xpath("//*[contains(text(),'Rain Drop')]");
    private final By SelectLength = By.id("inventory-variation-select-0");
    private final By DesiredLength = By.xpath("//*[@id='inventory-variation-select-0']/option[2]");
    private final By SelectingNecklaceStyle = By.id("inventory-variation-select-1");
    private final By DesiredStyle = By.xpath("//*[@id='inventory-variation-select-1']/option[2]");
    private final By AddToCart = By.xpath("//*[@id='listing-page-cart']//*[@type='submit']");
    private final By GoToCartButton = By.xpath("//*[contains(text(),'Go to')]");
    private final By Checkout = By.xpath("//*[@id='multi-shop-cart-list']//*[contains(text(),'checkout')]");
    private final By EmailInput = By.id("join_neu_email_field");
    private final By ContinueButton = By.xpath("//*[@id='join-neu-form']//*[@type='submit']");
    private final By PasswordInput = By.id("join_neu_password_field");
    private final By SignInButton = By.name("submit_attempt");
    private final By ShippingDetails = By.xpath("//*[@id='shipping-address-form']/div[1]/h1");

    private static final Logger LOGGER = LogManager.getLogger(PendantPage.class);

    public PendantPage(WebDriver driver) {
        this.driver = driver;
    }

    public PendantPage clickOnRainDropPendant() {
        ActOn.element(driver, RainDropNecklace).click();
        LOGGER.debug("Clicking the rain drop necklace");
        return this;
    }


    public PendantPage selectNecklaceLength() {
        String originalWindow = driver.getWindowHandle();

        LOGGER.debug("Handling the new tab");
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        LOGGER.debug("Selecting the necklace length 16 inches");
        ActOn.wait(driver, SelectLength).waitForElementToBeVisible();
        ActOn.element(driver, SelectLength).click();
        ActOn.element(driver, DesiredLength).click();
        return this;
    }

    public PendantPage selectNecklaceStyle() {
        LOGGER.debug("Selecting the necklace style to be cable");
        driver.navigate().refresh();
//        WebElement button = driver.findElement(SelectingNecklaceStyle);
//        button.click();
//        WebElement button1 = driver.findElement(SelectingNecklaceStyle);
//        button1.click();
//        ActOn.element(driver, SelectingNecklaceStyle).click();
        ActOn.element(driver, DesiredStyle).click();
        return this;
    }

    public PendantPage addToCart() {
        LOGGER.debug("Adding the necklace to cart");
        driver.navigate().refresh();
        ActOn.element(driver, AddToCart).click();
        return this;
    }

    public PendantPage goToCart() {
        LOGGER.debug("Going to the cart");
        ActOn.element(driver, GoToCartButton).click();
        return this;
    }

    public PendantPage checkOut () {
        LOGGER.debug("Clicking on checkout");
        driver.navigate().refresh();
        ActOn.element(driver, Checkout).click();
        return this;
    }

    public PendantPage enterEmail(String email) {
        LOGGER.debug("Entering email " + email);
        ActOn.element(driver, EmailInput).setValue(email);
        return this;
    }

    public PendantPage clickContinue() {
        LOGGER.debug("clicking on continue to the the next page");
        ActOn.element(driver, ContinueButton).click();
        return this;
    }

    public PendantPage enterPassword(String password) {
        LOGGER.debug("Entering password " + password);
        ActOn.element(driver, PasswordInput).setValue(password);
        return this;
    }

    public PendantPage clickOnSignIn() {
        LOGGER.debug("CLicking on sign in button");
        ActOn.element(driver, SignInButton).click();
        return this;
    }

    public PendantPage validateUserOnShippingPage() {
        LOGGER.debug("On checkout page with shipping details");
        ActOn.validate(driver, ShippingDetails).elementIsDisplayed();
        return this;
    }


}
