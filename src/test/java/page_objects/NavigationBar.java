package page_objects;

import command_providers.ActOn;
import io.cucumber.java.en_old.Ac;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationBar {
    public WebDriver driver;

    private final By EtsyLogo = By.xpath("//*[@id='logo']/svg");
    private final By SearchBar = By.name("search_query");
    private final By SearchButton = By.xpath("//*[@id='gnav-search']/div/div[1]/button");
    private final By ValentineDayShopTab = By.xpath("//*[@id='desktop-category-nav']/div[1]/div/ul/li[1]/a/span");
    private final By JewelryTab = By.xpath("//*[@id='desktop-category-nav']/div[1]/div/ul/li[2]");
    private final By NecklaceTab = By.id("side-nav-category-link-10873");
    private final By PendantTab = By.id("catnav-l3-10874");
    private final By ClothingShoesTab = By.xpath("//*[@id='desktop-category-nav']/div[1]/div/ul/li[3]/a");
    private final By AllClothingAndShoes = By.id("side-nav-category-link-10923");
    private final By WomenSectionInClothing = By.id("side-nav-category-link-10924");
    private final By WomenBoots = By.id("catnav-l4-10935");
    private final By HomeLivingTab = By.xpath("//*[@id='catnav-primary-link-891']");
    private final By WeddingPartyTab = By.xpath("//*[@id='catnav-primary-link-10983']");
    private final By ToysEntertainmentTab = By.xpath("//*[@id='catnav-primary-link-11049']");
    private final By ArtCollectiblesTab = By.xpath("//*[@id='catnav-primary-link-66']");
    private final By CraftSuppliesTab = By.xpath("//*[@id='catnav-primary-link-562']");
    private final By GiftsGiftCardTab = By.xpath("//*[@id='catnav-primary-link--10']");
    private final By Cart = By.xpath("//*[@id='gnav-header-inner']//span[3]");
//    private final By Cart = By.linkText("https://www.etsy.com/cart?ref=hdr-cart");
    private final By RingsForMen = By.xpath("//*[@id='content']//*[contains(text(),'rings men')]");
    private final By VikingRing = By.xpath("//*[contains(text(),'9th-10th')]");
    private final By CarbonRing = By.xpath("//*[contains(text(),'Fiber Ring')]");
    private final By RingSizeDropDown = By.id("inventory-variation-select-0");
    private final By DesiredRingSize = By.xpath("//*[@id='inventory-variation-select-0']/option[14]");
    private final By CarbonFiberOptionDropDown = By.id("inventory-variation-select-1");
    private final By DesiredCarbonFiber = By.xpath("//*[@id='inventory-variation-select-1']/option[3]");
    private final By AddToCart = By.xpath("//*[@id='listing-page-cart']//*[@type='submit']");




    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage navigateToHome() {
        ActOn.element(driver, EtsyLogo).click();
        LOGGER.debug("Navigating to the Etsy home page");
        return new HomePage(driver);
    }

    public ValentineShop navigateToValentinePage() {
        ActOn.element(driver, ValentineDayShopTab).click();
        LOGGER.debug("navigating to the valentine shop page");
        return new ValentineShop(driver);
    }

    public NavigationBar mouseHoverToJewelryTab() {
        LOGGER.debug("Mouse hover to the jewelry tab");
        ActOn.element(driver, JewelryTab).mouseHover();
        return this;
    }

    public NavigationBar mouseHoverToNecklace() {
        LOGGER.debug("Mouse hover to the necklace");
        ActOn.element(driver, NecklaceTab).click();
        return this;
    }

    public PendantPage clickOnPendant() {
        LOGGER.debug("Clicking on pendants");
        ActOn.element(driver, PendantTab).click();
        return new PendantPage(driver);
    }

    public NavigationBar mouseHoverToClothingAndShoesTab() {
        LOGGER.debug("Mouse hovering to clothing and shoes tab");
        driver.navigate().refresh();
        ActOn.wait(driver, ClothingShoesTab).waitForElementToBeVisible();
        ActOn.element(driver, ClothingShoesTab).mouseHover();
//        WebElement button = driver.findElement(ClothingShoesTab);
//        Actions action = new Actions(driver);
//        action.moveToElement(button);
//        WebElement subMenu = driver.findElement(WomenSectionInClothing);
//        action.moveToElement(subMenu);
//        WebElement button1 = driver.findElement(ClothingShoesTab);
//        action.moveToElement(button1).perform();
        return this;
    }

    public ClothingAndShoesPage clickOnAllClothingAndShoes() {
        LOGGER.debug("Clicking on all clothing and shoes");
        ActOn.element(driver, AllClothingAndShoes).click();
        return new ClothingAndShoesPage(driver);
    }

    public NavigationBar mouseHoverToWomenSection() {
        LOGGER.debug("Mouse hover to women section in clothing and shoes tab");
        ActOn.element(driver, WomenSectionInClothing).click();
        return this;
    }
    public ClothingAndShoesPage clickOnWomenBoots() {
        LOGGER.debug("Clicking on boots in women section");
        ActOn.element(driver, WomenBoots).click();
        return new ClothingAndShoesPage(driver);
    }

    public Cart navigateToCart() {
        LOGGER.debug("Navigating to the cart");
        ActOn.element(driver, Cart).click();
        return new Cart(driver);
    }

    public NavigationBar searchForRings(String rings) {
        LOGGER.debug("Searching for vintage rings");
        ActOn.element(driver, SearchBar).setValue(rings);
        ActOn.element(driver, SearchButton).click();
        return this;
    }

    public NavigationBar clickOnRingsForMen () {
        LOGGER.debug("Clicking on rings for men");
        driver.navigate().refresh();
        ActOn.element(driver, RingsForMen).click();
        return this;
    }

    public NavigationBar clickOnVikingRing() {
        LOGGER.debug("Clicking on viking ring");
        ActOn.element(driver, VikingRing).click();
        return this;
    }

    public NavigationBar clickOnCarbonFiberRing() {
        LOGGER.debug("clicking on carbon fiber ring with wood");
        ActOn.wait(driver, CarbonRing).waitForElementToBeVisible();
        ActOn.element(driver, CarbonRing).click();
        return this;
    }

    public NavigationBar selectRingSize() {
        LOGGER.debug("Selecting the ring size");
        driver.navigate().refresh();
        ActOn.element(driver, RingSizeDropDown).click();
        ActOn.element(driver, DesiredRingSize).click();
        return this;
    }

    public NavigationBar addRingToCart() {
        LOGGER.debug("Adding the ring to cart");
        String originalWindow = driver.getWindowHandle();

        LOGGER.debug("Handling the new tab");
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        ActOn.element(driver, AddToCart).click();
        return this;
    }
}
