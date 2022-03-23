package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    public WebDriver driver;

    private final By SignIn = By.xpath("//*[@id='gnav-header-inner']/div[4]/nav/ul/li[1]/button");
    private final By EmailInputField = By.name("email");
    private final By PasswordInputField = By.name("password");
    private final By SubmitButton = By.name("submit_attempt");
    private final By MyAccount = By.xpath("//*[@id='gnav-header-inner']//img");
    private final By ViewProfile = By.xpath("//*[text()='Abdulla']");
    private final By SignInError = By.xpath("//*[contains(text(),'incorrect')]");


    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage clickOnSignIn() {
        ActOn.element(driver, SignIn).click();
        LOGGER.debug("Clicking on sign in button on home page");
        return this;
    }

    public HomePage enterEmail(String value) {
        ActOn.element(driver, EmailInputField).setValue(value);
        LOGGER.debug("Entering email " + value);
        return this;
    }

    public HomePage enterPassword(String value) {
        ActOn.element(driver, PasswordInputField).setValue(value);
        LOGGER.debug("Entering password " + value);
        return this;
    }

    public HomePage clickSubmit() {
        ActOn.element(driver, SubmitButton).click();
        LOGGER.debug("Clicking on submit button");
        return this;
    }

    public HomePage verifySignInSuccessful() {
        ActOn.element(driver, MyAccount).click();
        ActOn.validate(driver, ViewProfile).elementIsDisplayed();
        return this;
    }

    public HomePage signInUnsuccessful(String error) {
        ActOn.validate(driver, SignInError).elementIsDisplayed();
        return this;
    }

}
