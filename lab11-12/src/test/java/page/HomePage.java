package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.TestDataReader;
import util.TestListener;

import java.time.Duration;

public class HomePage extends AbstractPage
{
    private static final String DESTINATION_STRING = TestDataReader.getTestData("testdata.location.destination");
    private static final String BASE_URL = "https://www.ihg.com";
    private final Logger logger = LogManager.getRootLogger();
    public static final String LOCATION_DESTINATION = "testdata.user.name";

    @FindBy(xpath = "//a[@class='brandNav-link u-link site-int-link' and text()='Our Brands']")
    private WebElement brandsButtonLocator;

    @FindBy(xpath = "//span[@class='language-text nav-middle']")
    private WebElement CountryMenuButtonLocator;

    @FindBy(id = "uhfLanguageSelection")
    private WebElement languageSubSelectionLocator;

    @FindBy(xpath = "//option[text()='Russian / русский']")
    private WebElement selectRussianButton;

    @FindBy(xpath = "//button[@class='buttonSave']")
    private WebElement saveLocalizationButtonLocator;

    @FindBy(id = "dest-input")
    private WebElement destinationInputFieldLocator;

    @FindBy(xpath = "//button[@class='search-button brand-background']")
    private WebElement searchButtonLocator;

    @FindBy(xpath = "//a[@class='resDirectNum']")
    private WebElement phoneButtonLocator;

    @FindBy(xpath = "//a[@class='socialElement__icon uhf_facebook' and @title='Facebook']")
    private WebElement facebookButtonLocator;

    @FindBy(xpath = "//a[@class='socialElement__icon uhf_twitter' and @title='Twitter']")
    private WebElement twitterButtonLocator;

    @FindBy(xpath = "//a[@class='utilityNav-link u-link nav-middle uhfpopup' and @title='Need Help?']")
    private WebElement needHelpButtonLocator;

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public BrandsPage goToBrandsPage()
    {
        WebElement brandsButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(brandsButtonLocator));
        brandsButton.click();
        logger.info("The BrandsPage is switched to");
        return new BrandsPage(driver);
    }

    public void changeLocalizationToRu()
    {
        WebElement countryMenuButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(CountryMenuButtonLocator));
        countryMenuButton.click();
        logger.info("Country menu is opened");
        languageSubSelectionLocator.click();
        logger.info("Language menu is opened");
        selectRussianButton.click();
        logger.info("Russian is selected");
        WebElement saveLocalizationButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(saveLocalizationButtonLocator));
        saveLocalizationButton.click();
        logger.info("Localization is saved");
    }

    public SearchPage searchDestination()
    {
        WebElement destinationInputField = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(destinationInputFieldLocator));
        destinationInputFieldLocator.click();
        destinationInputFieldLocator.sendKeys(DESTINATION_STRING);
        logger.info("The cursor was placed in the input field");
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
              .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        logger.info("Search button was pressed");
        return new SearchPage(driver);
    }

    public WebElement getCountryMenuButton()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CountryMenuButtonLocator));
    }

    public boolean isFeedbackClickable()
    {
        WebElement phoneButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(phoneButtonLocator));

        WebElement twitterButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(twitterButtonLocator));

        WebElement facebookButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(facebookButtonLocator));

        if(phoneButton.isDisplayed() && twitterButton.isDisplayed() && facebookButton.isDisplayed())
            return true;
        else return false;
    }

    public HelpPage goToHelpPage()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(needHelpButtonLocator)).click();
        return new HelpPage(driver);
    }
}
